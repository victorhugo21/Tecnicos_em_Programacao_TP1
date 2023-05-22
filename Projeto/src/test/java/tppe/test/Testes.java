package tppe.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tppe.main.LerJSON;

import org.junit.Before;
import org.junit.BeforeClass;

public class Testes {
	
	LerJSON arquivo;
	
	@Before
	public void setup() {
		arquivo = new LerJSON();
	}
	

	@Test
    public void verificaCompletudeJsonOuX() {
        assertEquals(100, arquivo.OuExclusivo("arquivosTeste/arquivo.json"), 0);
    }
	
	@Test
    public void verificaCompletudeJsonOuX2() {
        assertEquals(50, arquivo.OuExclusivo("arquivosTeste/arquivo2.json"), 0);
    }
	
	
	@Test
    public void verificaCompletudeJsonOuI() {
        assertEquals(50, arquivo.OuInclusivo("arquivosTeste/arquivo.json"), 0);
    }
	
	@Test
    public void verificaCompletudeTotal() {
        assertEquals(81.25f, arquivo.MultiCampos("arquivosTeste/arquivo.json"), 0);
    }
	

}
