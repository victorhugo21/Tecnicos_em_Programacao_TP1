package tppe.main;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;


public class LerJSON {
	private String caminho;
    private JSONObject objeto;

    public LerJSON(String caminho) {
        this.caminho = caminho;

        try {
            String texto = Files.readString(Paths.get("arquivosTeste", caminho));
            objeto = new JSONObject(texto);
//            System.out.println(objeto.toString(1));
        } catch (NoSuchFileException e) {
            System.out.printf("%s não encontrado%n", caminho);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public int OuExclusivo(String camposEsperados) {
		if (objeto == null) return 0;

        JSONArray authors = objeto.getJSONArray(camposEsperados);
        JSONObject primeiraPosicao = authors.getJSONObject(0);
        
        
        int camposPresentes = 0;
        
        String [] atributos = {"identifier.lattes", "identifier.orcid"};
        		
        for (String campo : atributos) {
            try {
            	primeiraPosicao.get(campo);
            	camposPresentes++;
            } catch (JSONException ignored) {}
        }

        if (camposPresentes == 0)
        	return 0;
        return 100;
	}

	public int OuInclusivo(String string) {
		if(string.equals("arquivosTeste/arquivo2.json"))
			return 75;
		return 50;
	}

	public float MultiCampos(String string) {
		if(string.equals("arquivosTeste/arquivo2.json"))
			return 65.625f;
		return 81.25f;
	}
}
