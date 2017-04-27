import java.util.*;
import java.text.*;
import java.io.*;
//import java.util.Vector;
//import java.io.File

class RubricaInFile  extends Rubrica
{
  public String nomeFile;
  
  public RubricaInFile(String nomeFile) //"elenco.txt"
  {
  // Chiama il costruttore della classe Rubrica
    super();
    this.nomeFile = nomeFile;
    System.out.println(" sono nel costruttore di RubricaInFile. this.nomeFile =  "  +this.nomeFile + "; \n");
      File f_test;
	  f_test=new File(nomeFile);

	  if(f_test.exists())
			System.out.println("Il file "+nomeFile+" esiste");
	  else
			System.out.println("Il file "+nomeFile+" non esiste");
 
      if (f_test.exists()) {
		InitVettore();
     }
  }
 
   public void InitVettore()
  {
    FileReader f = null;
    BufferedReader fIN = null;
    Voce v;
    String s;
    StringTokenizer st;

    try
    {
      f = new FileReader(nomeFile);
      fIN = new BufferedReader(f);
    }
    catch (IOException e)
    {
      System.out.println("Errore nell'apertura del file: " + nomeFile);
      System.exit(1);
    }


    try
    {
      s = fIN.readLine();

      // Legge e stampa una riga
      while (s != null)
      {
		v = new Voce();
        st = new StringTokenizer(s, ";"); //carattere separatore fra i dati si è scelto il ';'
        v.nome = st.nextToken();
        v.telefono = st.nextToken();
        v.indirizzo = st.nextToken();
        v.compleanno = st.nextToken();
        String numeroLetto = st.nextToken();
        v.eta = Integer.valueOf(numeroLetto).intValue();

        elenco.addElement(v); // aggiorno il vettore
        
        s = fIN.readLine();
      }
    }
    catch (IOException e)
    {
      System.out.println("Errore nella lettura del file: " + nomeFile);
      System.exit(1);
    }

    try
    {
      f.close();
    }
    catch (IOException e)
    {
      System.out.println("Errore nella chiusura del file: " + nomeFile);
      System.exit(1);
    }
  }
 
  public void aggiungiVoce(Voce v)
  {
	//	elenco.addElement(v); // aggiorno il vettore ma non lo ordina!!
		super.aggiungiVoce(v); // aggiorno il vettore ordinandolo
     ScriviDati(); // aggiorno il file
  }

  public void eliminaVoce(int indice)
  {
	InputStreamReader input = new InputStreamReader(System.in);
	BufferedReader tastiera = new BufferedReader(input);
    Voce v;
    String risposta = new String();
    try
    {
       v = (Voce) elenco.elementAt(indice);
    }
    catch (Exception e)
    {
      System.out.println("Eliminazione non possibile.");
      return;
    }
	  
	v.stampa();
	System.out.println("Vuoi veramente eliminare la voce selezionata dall'archivio? S/N");
	try
		{
			risposta = tastiera.readLine();
		}
	catch(IOException e) {}
		
	// risposta=risposta.toLowerCase();
    System.out.println("\nRisposta ="+risposta);
	if (risposta.toLowerCase().compareTo("s")==0)
		{
 
		try
		{
			elenco.removeElementAt(indice);
			ScriviDati(); //aggiorno il file
			System.out.println("Eliminazione effettuata.");
		}
		catch (Exception e)
		{
			System.out.println("Eliminazione non possibile.");
		return;
		}
 	
	}
  }

  public void eliminaVoce(int indice, String risposta)
  {
    Voce v;
    try
    {
       v = (Voce) elenco.elementAt(indice);
    }
    catch (Exception e)
    {
      System.out.println("Eliminazione non possibile.");
      return;
    }
	  
	v.stampa();
    System.out.println("\nRisposta ="+risposta);
	if (risposta.toLowerCase().compareTo("s")==0)
		{
 
		try
		{
			elenco.removeElementAt(indice);
			ScriviDati(); //aggiorno il file
			System.out.println("Eliminazione effettuata.");
		}
		catch (Exception e)
		{
			System.out.println("Eliminazione non possibile.");
		return;
		}
 	
	}
  }



  public void visualizza()
  {
       // Chiama il costruttore della classe LeggiDati 
  System.out.println("\nRUBRICA in file confronta contenuto con il vettore:");
      LeggiDati();
  System.out.println("\nRUBRICA in vettore confronta contenuto con il file:");
    
    Voce v;

    System.out.println("\nRUBRICA");
    for(int i=0; i<elenco.size(); i++)
    {
      System.out.print("posizione " + i + " -> ");
      v = (Voce) elenco.elementAt(i);
      v.stampa();
    }
    
  }

  

  public void LeggiDati()
  {
    FileReader f = null;
    BufferedReader fIN = null;
    Voce v;
    String s;
    StringTokenizer st;

    try
    {
      f = new FileReader(nomeFile);
      fIN = new BufferedReader(f);
    }
    catch (IOException e)
    {
      System.out.println("Errore nell'apertura del file: " + nomeFile);
      System.exit(1);
    }

    v = new Voce();

    try
    {
      s = fIN.readLine();

      // Legge e stampa una riga
      while (s != null)
      {
        st = new StringTokenizer(s, ";"); //carattere separatore fra i dati si è scelto il ';'
        v.nome = st.nextToken();
        v.telefono = st.nextToken();
        v.indirizzo = st.nextToken();
        v.compleanno = st.nextToken();
        String numeroLetto = st.nextToken();
        v.eta = Integer.valueOf(numeroLetto).intValue();

        v.stampa();
        s = fIN.readLine();
      }
    }
    catch (IOException e)
    {
      System.out.println("Errore nella lettura del file: " + nomeFile);
      System.exit(1);
    }

    try
    {
      f.close();
    }
    catch (IOException e)
    {
      System.out.println("Errore nella chiusura del file: " + nomeFile);
      System.exit(1);
    }
  }

  public void ScriviDati()
  {
    Voce v = null;
    FileWriter f = null;
    PrintWriter fOUT = null;

    try
    {
      f = new FileWriter(nomeFile);
      fOUT = new PrintWriter(f);
    }
    catch (IOException e)
    {
      System.out.println("Errore nell'apertura del file: " + nomeFile);
      System.exit(1);
    }

    v = new Voce();
      // scrive sul file
 		for(int i=0; i<elenco.size(); i++)
		{
			v = (Voce) elenco.elementAt(i);
			fOUT.println(v.nome+";"+v.telefono+";"+v.indirizzo+";"+v.compleanno+";"+v.eta);
		}
      fOUT.flush();

    try
    {
      f.close();
    }
    catch (IOException e)
    {
      System.out.println("Errore nella chiusura del file: " + nomeFile);
      System.exit(1);
    }
  }

 }
