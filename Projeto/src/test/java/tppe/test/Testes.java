package tppe.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tppe.main.LerJSON;

@RunWith(Parameterized.class)
public class Testes {

    LerJSON arquivo;
    float completudeEsperada;
    int completudeOuX;
    int completudeOuI;
    
    String[] camposEsperados = {
            "title",
            "publicationDate",
            "language",
            "authors"           
    }; 

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {"arquivo.json", 100, 100, 100},
                {"arquivo2.json", 75, 0, 0},
                {"arquivo3.json", 81.25f, 0, 50}
        });
    }

    public Testes(String caminho, float completudeEsperada, int completudeOuX, int completudeOuI) {
        this.arquivo = new LerJSON(caminho);
        this.completudeEsperada = completudeEsperada;
        this.completudeOuX = completudeOuX;
        this.completudeOuI = completudeOuI;
        
    }

    @Test
    public void verificaCompletudeJsonOuX() {
        assertEquals(completudeOuX, arquivo.OuExclusivo(camposEsperados[3]), 0);
    }
    
    @Test
    public void verificaCompletudeJsonOuI() {
        assertEquals(completudeOuI, arquivo.OuInclusivo(camposEsperados[3]), 0);
    }

    @Test
    public void verificaCompletudeJsonMulti() {
        assertEquals(completudeEsperada, arquivo.MultiCampos(camposEsperados), 0);
    }

}