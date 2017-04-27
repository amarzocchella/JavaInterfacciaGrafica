import java.util.Vector;

class Rubrica
{
  protected Vector elenco;
  
  public Rubrica()
  {
    elenco = new Vector(1,1);
  }

  public void aggiungiVoce(Voce v)
  {
      Voce v_tmp, prec;
/* metto subito in fondo e guadagno un posto poi comincio i confronti 
 * e se deve andare avanti sposto indietro l'elemento corrente! */
     elenco.addElement(v); 
	  v_tmp=v;
       int i=elenco.size()-1; // inizializzo i con la posizione dell'ultimo elemento inserito!
	// Inizio ad ordinarli per portare l'ultimo elemento nella posizione che gli spetta!
       int Pos_NuovaVoce=i;
        while (i>0)// ho almeno due elementi nel vector
        {
			prec = (Voce) elenco.elementAt(i-1);
			if (prec.getNome().compareTo(v_tmp.getNome()) > 0) //ordine crescente
		//	if (prec.getNome().compareTo(v_tmp.getNome()) < 0) //ordine decrescente
			{ // Li scambio di posto
				elenco.set(i-1, v_tmp);
				elenco.set(i, prec);
          } else break; // Se non ci sono scambi l'array è già ordinato. Quindi termino il ciclo!
			i--;
        }
  }

  public void eliminaVoce(int indice)
  {
    try
    {
      elenco.removeElementAt(indice);
    }
    catch (Exception e)
    {
      System.out.println("Eliminazione non possibile.");
      return;
    }

    System.out.println("Eliminazione effettuata.");
  }

  public void visualizza()
  {
    Voce v;

    System.out.println("\nRUBRICA");
    for(int i=0; i<elenco.size(); i++)
    {
      System.out.print("posizione " + i + " -> ");
      v = (Voce) elenco.elementAt(i);
      v.stampa();
    }
  }
}
