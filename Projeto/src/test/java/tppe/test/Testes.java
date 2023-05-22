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
    int completudeOuX;
    
    String[] camposEsperados = {
            "title",
            "publicationDate",
            "language",
            "authors"           
    }; 

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {"arquivo.json", 100},
                {"arquivo2.json", 0},
                {"arquivo3.json", 0}
        });
    }

    public Testes(String caminho,int completudeOuX) {
        this.arquivo = new LerJSON(caminho);
        this.completudeOuX = completudeOuX;
    }

	@Test
    public void verificaCompletudeJsonOuX() {
        assertEquals(completudeOuX, arquivo.OuExclusivo(camposEsperados[3]), 0);
    }
	
	@Test
    public void verificaCompletudeJsonOuI() {
        assertEquals(50, arquivo.OuInclusivo("arquivosTeste/arquivo.json"), 0);
    }
	
	@Test
    public void verificaCompletudeJsonOuI2() {
        assertEquals(75, arquivo.OuInclusivo("arquivosTeste/arquivo2.json"), 0);
    }
	
	@Test
    public void verificaCompletudeTotal() {
        assertEquals(81.25f, arquivo.MultiCampos("arquivosTeste/arquivo.json"), 0);
    }
	
	@Test
    public void verificaCompletudeTotal2() {
        assertEquals(65.625f, arquivo.MultiCampos("arquivosTeste/arquivo2.json"), 0);
    }

}
