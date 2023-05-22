package tppe.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tppe.main.LerJSON;

import org.junit.BeforeClass;

public class Testes {

	@Test
    public void verificaCompletudeJsonOuX() {
		LerJSON arquivo = new LerJSON();
        assertEquals(100, arquivo.OuExclusivo("arquivosTeste/arquivo.json"), 0);
    }
	
	@Test
    public void verificaCompletudeJsonOuI() {
		LerJSON arquivo = new LerJSON();
        assertEquals(50, arquivo.OuInclusivo("arquivosTeste/arquivo.json"), 0);
    }
	

}
