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

	public int OuInclusivo(String camposEsperados) {
		if (objeto == null) return 0;

        JSONArray authors = objeto.getJSONArray(camposEsperados);
        JSONObject primeiraPosicao = authors.getJSONObject(0);
        
        
        int camposPresentes = 0;
        
        String [] atributos = {"nationality", "birthCountry", "birthCity", "birthState"};
        		
        for (String campo : atributos) {
            try {
            	primeiraPosicao.get(campo);
            	camposPresentes++;
            } catch (JSONException ignored) {}
        }
        System.out.println(camposPresentes);
        return (100*camposPresentes)/4;
	}

	public float MultiCampos(String[] camposEsperados) {
		if (objeto == null) return 0;

        int completudeOuX = OuExclusivo(camposEsperados[3]);
        int completudeOuI = OuInclusivo(camposEsperados[3]);
        
        float completudeAutor = completudeOuI * 0.5f + completudeOuX * 0.5f;
        
        int camposPresentes = 0;

        for (int i = 0; i<3; i++) {
            try {
                objeto.get(camposEsperados[i]);
                camposPresentes++;
            } catch (JSONException ignored) {}
        }
        
        return camposPresentes*100/4 + completudeAutor*0.25f;
	}
}
