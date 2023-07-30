package beans;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Kandidat implements Comparable<Kandidat> {
    
    @Min (1) @Max (200) 
    private int brojprijave;
    @Size(min = 3, message = "ime mora imati najmanje 3 karaktera!")
    private String ime;
    @Size(min = 3, message = "prezime mora imati najmanje 3 karaktera!")
    private String prezime;
    private String srednja;
    @DecimalMin (value = "2.0", message="prosek mora biti veći od 2.0") @DecimalMax (value = "5.0", message="prosek mora biti manji od 5.0") // za realne brojeve. Ako se koristi  @Min (2) @Max (5) nastaje problem pri unosu 5.8 (prolazi)
    private double prosekprvi;
    @DecimalMin (value = "2.0", message="prosek mora biti veći od 2.0") @DecimalMax (value = "5.0", message="prosek mora biti manji od 5.0")
    private double prosekdrugi;
    @DecimalMin (value = "2.0", message="prosek mora biti veći od 2.0") @DecimalMax (value = "5.0", message="prosek mora biti manji od 5.0")
    private double prosektreci;
    @DecimalMin (value = "2.0", message="prosek mora biti veći od 2.0") @DecimalMax (value = "5.0", message="prosek mora biti manji od 5.0")
    private double prosekcetvrti;
    @Min (0) @Max (60)
    private int prijemni;

    
    public Kandidat() {
        
    }
    
    public Kandidat(int brojprijave, String ime, String prezime, String srednja, double prosekprvi, double prosekdrugi, double prosektreci, double prosekcetvrti, int prijemni) {
        this.brojprijave = brojprijave;
        this.ime = ime;
        this.prezime = prezime;
        this.srednja = srednja;
        this.prosekprvi = prosekprvi;
        this.prosekdrugi = prosekdrugi;
        this.prosektreci = prosektreci;
        this.prosekcetvrti = prosekcetvrti;
        this.prijemni = prijemni;
    
    }

    public int getBrojprijave() {
        return brojprijave;
    }

    public void setBrojprijave(int brojprijave) {
        this.brojprijave = brojprijave;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getSrednja() {
        return srednja;
    }

    public void setSrednja(String srednja) {
        this.srednja = srednja;
    }

    public double getProsekprvi() {
        return prosekprvi;
    }

    public void setProsekprvi(double prosekprvi) {
        this.prosekprvi = prosekprvi;
    }

    public double getProsekdrugi() {
        return prosekdrugi;
    }

    public void setProsekdrugi(double prosekdrugi) {
        this.prosekdrugi = prosekdrugi;
    }

    public double getProsektreci() {
        return prosektreci;
    }

    public void setProsektreci(double prosektreci) {
        this.prosektreci = prosektreci;
    }

    public double getProsekcetvrti() {
        return prosekcetvrti;
    }

    public void setProsekcetvrti(double prosekcetvrti) {
        this.prosekcetvrti = prosekcetvrti;
    }

    public int getPrijemni() {
        return prijemni;
    }

    public void setPrijemni(int prijemni) {
        this.prijemni = prijemni;
    }
 
    public int getUspeh() {
        return (int) ((prosekprvi+prosekdrugi+prosektreci+prosekcetvrti)*2+prijemni);
    }
    @Override
    public int compareTo(Kandidat o) {  
        Integer ukupniP = o.getUspeh();
        if(this.getUspeh() - o.getUspeh() == 0){
            return this.brojprijave - o.brojprijave;
        }
        return ukupniP.compareTo(this.getUspeh());
    }
   
}
