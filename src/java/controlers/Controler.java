package controlers;

import data.Podaci;
import beans.Kandidat;
import beans.Korisnik;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

@Named(value = "controler")
@SessionScoped
public class Controler implements Serializable {
    
    @Size(min = 3, message = "Korisničko ime mora imati najmanje 3 karaktera!")
    private String korime;
    private String lozinka;
    private String poruka;
    
    List<Kandidat> kandidati= Podaci.listaKandidata;
    Kandidat noviKandidat = new Kandidat();
    
    private Korisnik loggedKorisnik = new Korisnik();
    
    public Controler() {
         
    }

    public String getKorime() {
        return korime;
    }

    public void setKorime(String korime) {
        this.korime = korime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public List<Kandidat> getKandidati() {
        return kandidati;
    }

    public void setKandidati(List<Kandidat> kandidati) {
        this.kandidati = kandidati;
    }

    public Kandidat getNoviKandidat() {
        return noviKandidat;
    }

    public void setNoviKandidat(Kandidat noviKandidat) {
        this.noviKandidat = noviKandidat;
    }

    public Korisnik getLoggedKorisnik() {
        return loggedKorisnik;
    }

    public void setLoggedKorisnik(Korisnik loggedKorisnik) {
        this.loggedKorisnik = loggedKorisnik;
    }
    public String signOut(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }
    
    public String login() {
        String sledecaStranica = null;
        if(Podaci.postojiKorisnik(this.korime, this.lozinka)) {
            Collections.sort(kandidati);
            Korisnik korisnik = Podaci.getKorisnik(korime);
            this.loggedKorisnik.setKorime(this.korime);
            
            if(korisnik.getTip().equals("Administrator")) {
                poruka = "";
                sledecaStranica = "dodaj";
            }
            else if(korisnik.getTip().equals("Ostali")) {
                poruka = "";
                sledecaStranica = "ranglista";
            }
            else {
                this.poruka = "Ne postoji korisnik u sistemu ili je lozinka neispravna!";
          }  
       }
        return sledecaStranica;
    }
    
    public String goToRangLista() {
        return "ranglista";
    }
    
    public String dodaj() {
        kandidati.add(noviKandidat);
        Collections.sort(kandidati);
        noviKandidat = new Kandidat(); // ponistavanje svih vrednosti
        return null;
    }
    
    private static SelectItem[] srednjeSkole = {
        new SelectItem(null, "Odaberite skolu:", "", false, false, true),
        new SelectItem("Elektrotehnicka skola"),
        new SelectItem("Ekonomska skola"),
        new SelectItem("Gimazija Valjevo"),
        new SelectItem("Gimnazija Kragujevac"), //...
        new SelectItem("Trogodisnja", "Trogodisnja", "", true)  //nemaju pravo 
    };
    
    public SelectItem[] getsrednjeSkole() {
          return srednjeSkole; 
    }  
}
