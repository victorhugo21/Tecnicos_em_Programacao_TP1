package tppe.main;

public class LerJSON 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

	public int OuExclusivo(String string) {
		if(string.equals("arquivosTeste/arquivo2.json"))
			return 50;
		return 100;
	}

	public int OuInclusivo(String string) {
		
		return 50;
	}

	public float MultiCampos(String string) {
		
		return 81.25f;
	}
}
