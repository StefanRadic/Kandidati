/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import beans.Kandidat;
import beans.Korisnik;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Stefan
 */
public class Podaci {
    
    public static Map<String,Korisnik> mapaKorisnici = new HashMap<String,Korisnik>();
    public static List<Kandidat> listaKandidata = new ArrayList<Kandidat>();
    
    static {
        mapaKorisnici.put("admin", new Korisnik("admin", "pass123", "Marko", "Markovic","Administrator"));
        mapaKorisnici.put("adm", new Korisnik("adm", "pass123", "Petar", "Petrovic", "Administrator"));
        mapaKorisnici.put("user1", new Korisnik("user1", "pass123", "Nikola", "Petrovic", "Ostali"));
        mapaKorisnici.put("user2", new Korisnik("user2", "pass123", "Ana", "Popadic", "Ostali"));
        listaKandidata.add(new Kandidat(119, "Ivan", "Ilic", "Elektrotehnicka skola", 3.3, 4.07, 4.33, 4.6, 33));
        listaKandidata.add(new Kandidat(131, "Marko", "Jeremic", "Gimnazija Valjevo", 4.74, 4.87, 5.0, 5.0, 54));
        listaKandidata.add(new Kandidat(15, "Nikola", "Novakovic", "Gimnazija Kragujevac", 3.0, 4.11, 4.23, 4.50, 17));
        listaKandidata.add(new Kandidat(79, "Marija", "Peric", "Elektrotehnicka skola", 2.44, 2.37, 3.13, 2.77, 7));
        listaKandidata.add(new Kandidat(33, "Ana", "Petrovic", "Ekonomska skola", 4.14, 4.17, 4.50, 4.33, 47));
  
    }

    public static Korisnik getKorisnik(String korime) {
        return mapaKorisnici.get(korime);
    }


    public static boolean postojiKorisnik(String korime, String lozinka) {
        Korisnik k = mapaKorisnici.get(korime);
        return (k != null) && k.getLozinka().equals(lozinka);
    }
}
