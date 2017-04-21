import java.io.*;

class Voce 
{
  public String nome = new String();
  public String telefono = new String();
  public String indirizzo = new String();
  public String compleanno = new String();// mese e giorno, es.: "01-15" 
  public int eta;

  public Voce()
  {     
	}
  public void LeggiDati()
  {     
	  System.out.println(" sono nel costruttore di Voce.\n");
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader tastiera = new BufferedReader(input);

    System.out.print("Nome: ");
    try
    {
      nome = tastiera.readLine();
    }
    catch(IOException e) {}

    System.out.print("Telefono: ");
    try
    {
      telefono = tastiera.readLine();
    }
    catch(IOException e) {}

    System.out.print("Indirizzo: ");
    try
    {
      indirizzo = tastiera.readLine();
    }
    catch(IOException e) {}


    System.out.print("Compleanno: inteso come mese e giorno, es.: 01-15 ");
    try
    {
      compleanno = tastiera.readLine();
    }
    catch(IOException e) {}
 
    System.out.print("Eta': ");
    try
    {
      	String numeroLetto = tastiera.readLine();
		eta = Integer.valueOf(numeroLetto).intValue();
    }
    catch(IOException e) {}
  }

  public void stampa()
  {
    System.out.println(nome+" tel.: " + telefono+" Ind.: " +indirizzo);
    System.out.println("\t compleanno: "+compleanno+" eta': " + eta);
  }
 
  public String getNome()
  {
    return nome;
  }
}
