/*FinestraPrincipale.java 
 * Con diversi elementi.
*/
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.util.Vector;

public class FinestraPrincipale  extends RubricaInFile
{       public String nomeFile;
		private static  Border bordo1, bordo2, bordo3, bordo4, bordo5;
		
		GestisciPulsanti listener = new GestisciPulsanti();
		private DialogFormManager dialogFormManager; 

//////////////////////////////////////////

// Definisco l'interfaccia utente dell'applicativo
	// aggiungo alcuni componenti alla finestra
		JPanel pp=new JPanel(); // creo un oggetto panel di nome pp sarà il pannello principale
// creo altri oggetti panel di nome p_sopra, p_centro e p_sotto li metterò nel pannello principale
		JPanel p_sopra=new JPanel(); 
		JPanel p_sopra_1=new JPanel(); 
		JPanel p_sopra_2=new JPanel(); 

		JPanel p_centro=new JPanel(); 
		JPanel p_centro_1=new JPanel(); 
		JPanel p_centro_2=new JPanel(); 

		JPanel p_sotto=new JPanel(); 
		JPanel p_sotto_1=new JPanel();		
		JPanel p_sotto_2=new JPanel();		
// creo alcuni componenti da inserire sui Panel di sopra  
		JLabel  lb1  = new JLabel("Nome:"); JTextField nome= new JTextField();
		JLabel  lb2  = new JLabel("Tel."); JTextField tel= new JTextField();
		JLabel  lb3  = new JLabel("Indirizzo"); JTextField indirizzo= new JTextField();
		JLabel  lb4  = new JLabel("Compleanno (mm-gg)"); JTextField compleanno= new JTextField();
		JLabel  lb5  = new JLabel("Età"); JTextField eta= new JTextField();


// creo alcuni componenti da inserire sui Panel di centro  		

		JLabel jlbMenu= new JLabel("Menu");
		String[] menuStrings = { "Segli un opzione e premi esegui.", "1) Aggiungi voce", "2) Elimina voce", "3) Aggiorna rubrica", "4) Stampa rubrica (Stampa in terminal)" };
		JComboBox CBmenu = new JComboBox(menuStrings);    // Menu di scelta operazione

		JButton BtnEsegui = new JButton("ESEGUI");
		JButton BtnEsci = new JButton("ESCI");

// creo alcuni componenti da inserire sul Panel di sotto  		
		JLabel jlbPicture;
	//	String[] sceltaStrings = { "Angelo Branduardi", "Antonio Gramsci", "Franco Rosi", "Paolo Rossi", "Lucio Battisti" };
//		JComboBox CBscelta = new JComboBox(sceltaStrings);    // Menu di scelta operazione
		Vector sceltaStrings = new Vector(0,1); //Inizializzo in initDati con contenuto del file di testo della rubrica
	//	sceltaStrings.addElement(sceltaStrings[0]);sceltaStrings.addElement(sceltaStrings[1]);
	//	sceltaStrings.addElement(sceltaStrings[2]);sceltaStrings.addElement(sceltaStrings[3]);
	//	sceltaStrings.addElement(sceltaStrings[4]);

		JComboBox CBscelta = new JComboBox(sceltaStrings);    // Menu di scelta operazione


                              // Costanti per la selezione del menu
  static final byte Aggiungi=1;     // 1) Aggiungi voce
  static final byte Elimina=2;     // 2) Elimina voce
  static final byte Aggiorna=3;     // 3) Aggiorna rubrica
  static final byte Stampa=4;    // 4) Stampa rubrica (Stampa in terminal)

//////////////////////// costruttore di FinestraPrincipale
	public FinestraPrincipale(String nomeFile)
	{// il costruttore
		super(nomeFile);
		this.nomeFile = nomeFile;
		initDati();
		initGrafica();
    	}

  public void initDati() // Inizializza alcune parti dell'applicativo

	{ //sceltaStrings
		Voce v; 
		int dim=sceltaStrings.size();
	//	CBscelta.removeAllItems();
		for(int i=0; i<elenco.size(); i++)
		{
			v = (Voce) elenco.elementAt(i);
//			sceltaStrings[i] = v.nome;
		//	CBscelta.addItem(sceltaStrings[i]);
//			CBscelta.insertItemAt(sceltaStrings[i], i);
			if (dim<1){sceltaStrings.addElement(v.nome);}
			 else sceltaStrings.set(i,v.nome); 
//			CBscelta.insertItemAt(sceltaStrings.elementAt(i), i);
//			CBscelta.insertItemAt(v.nome, i);
	//		CBscelta.addItem(v.nome);
			if (i==0){nome.setText(v.nome); tel.setText(v.telefono); indirizzo.setText(v.indirizzo);
				compleanno.setText(v.compleanno); eta.setText(Integer.toString(v.eta));}
		}
/*				CBscelta.removeAllItems();
				CBscelta.addItem(temp);
				CBscelta.revalidate(); //Aggiorna ComboBox 
				pp.revalidate(); //Aggiorna panel 
				pp.repaint(); //Ridisegna il panel 
*/		
	 }

  public void initGrafica() // Inizializza L'interfaccia grafica dell'applicativo

 {
// Creo l'oggetto f come istanza/esemplare della classe JFrame, chiamando il costruttore JFrame()
	JFrame f = new JFrame(); 
	dialogFormManager = new DialogFormManager(f);// Creo la finestra secondaria
// Imposto il layout dei Panel principale
		pp.setLayout(new BorderLayout());

// inserisco i due pannelli p_sopra_1 e p_sopra_2 nel pannello p_sopra
		p_sopra.add(p_sopra_1);  p_sopra.add(p_sopra_2);

// inserisco i due pannelli p_centro_1 e p_centro_2 nel pannello p_centro
		p_centro.add(p_centro_1);  p_centro.add(p_centro_2);
// inserisco i due pannelli p_sotto_1 e p_sotto_2 nel pannello p_sotto
		p_sotto.add(p_sotto_1); p_sotto.add(p_sotto_2);
	
// inserisco i pannelli p_sopra, p_centro e p_sotto  nel pannello principale
		pp.add(p_sopra);  pp.add(p_centro); pp.add(p_sotto);

// inserisco il pannello principale nel Container

	//	f.add(pp); // aggiungo l'oggetto Panel al frame
		Container c = f.getContentPane();
		c.add(pp); 

		// Istanzio i bordi colorati, di tipo "Line Border" con spessore di bordo 2
		bordo1 = BorderFactory.createLineBorder(Color.red, 2);
		bordo2 = BorderFactory.createLineBorder(Color.yellow, 2);
		bordo3 = BorderFactory.createLineBorder(Color.green, 2);
		bordo4 = BorderFactory.createLineBorder(Color.magenta, 2);
		bordo5 = BorderFactory.createLineBorder(Color.cyan, 2);

		// Coloro gli sfondi dei pannelli.
		pp.setBackground(Color.BLUE);
		p_sopra.setBackground(Color.darkGray);
		p_sopra_1.setBackground(Color.lightGray);
		p_sopra_2.setBackground(Color.yellow);
		p_centro.setBackground(Color.darkGray);
		p_centro_1.setBackground(Color.lightGray);
		p_centro_2.setBackground(Color.yellow);
		p_sotto.setBackground(Color.green);
		p_sotto_1.setBackground(Color.lightGray);
		p_sotto_2.setBackground(Color.yellow);
		// Imposto i bordi colorati per i pannelli	
		pp.setBorder(bordo1);
		p_sopra.setBorder(bordo2);
		p_sopra_1.setBorder(bordo3);
		p_sopra_2.setBorder(bordo4);
		p_centro.setBorder(bordo2);
		p_centro_1.setBorder(bordo3);
		p_centro_2.setBorder(bordo4);
		p_sotto.setBorder(bordo5);
		p_sotto_1.setBorder(bordo3);
		p_sotto_2.setBorder(bordo4);

// Imposto i Listener per i pulsanti
		BtnEsci.addActionListener(listener);
		BtnEsci.setActionCommand (GestisciPulsanti.ESCI) ; 

		BtnEsci.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(MouseEvent e) { BtnEsci_mousePressed(e);	}});

		BtnEsegui.addActionListener(listener);
		BtnEsegui.setActionCommand (GestisciPulsanti.ESEGUI) ; 

		BtnEsegui.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(MouseEvent e) { BtnEsegui_mousePressed(e);	}});

		
// Imposto il layout dei Panel di sopra   
    p_sopra.setLayout(new GridLayout(1,2));
  //  p_sopra.setLayout(new BorderLayout());
    p_sopra_1.setLayout(new GridLayout(5,1));
    p_sopra_2.setLayout(new GridLayout(5,1));
// Imposto dimensione Etichette e caselle di testo, ma avrà effetto solo imposto setLayout(null) per il Panel che li contiene! 
			Dimension lb1Size=lb1.getPreferredSize();
			lb1.setBounds(10, 10, lb1Size.width, lb1Size.height);
			Dimension nomeSize=nome.getPreferredSize();
			nome.setBounds(15+ lb1Size.width, 10, nomeSize.width, nomeSize.height);
// Imposto dimensione Etichette e caselle di testo, ma avrà effetto solo imposto setLayout(null) per il Panel che li contiene! 
			Dimension lb2Size=lb2.getPreferredSize();
			lb2.setBounds(10, 10, lb2Size.width, lb2Size.height);
			Dimension indirizzoSize=indirizzo.getPreferredSize();
			indirizzo.setBounds(15+ lb2Size.width, 10, indirizzoSize.width, indirizzoSize.height);
// Inserisco i componenti sui Panel di sopra
		p_sopra_1.add(lb1); p_sopra_2.add(nome);
		p_sopra_1.add(lb2); p_sopra_2.add(tel);
		p_sopra_1.add(lb3); p_sopra_2.add(indirizzo);
		p_sopra_1.add(lb4); p_sopra_2.add(compleanno);
		p_sopra_1.add(lb5); p_sopra_2.add(eta);

// Formatto e Inserisco i componenti sui Panel di centro

// Inizializzo il primo elemento della lista e imposto i Listener per la ComboBox CBmenu   
		CBmenu.setSelectedIndex(0);
		CBmenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox jcmbType = (JComboBox) e.getSource();
				String cmbType = (String) jcmbType.getSelectedItem();
				String messaggio = "Opzione Menu: "+ cmbType.trim()+ "  "  + e.getActionCommand();
				JOptionPane.showMessageDialog(null, 
				messaggio, 
				"Conferma",
				JOptionPane.INFORMATION_MESSAGE);
			//	esegui(); //Questa chiamata al metodo esegui anticipa e rende non più necessario il click sul pulsante esegui. 
			}
		});

// Imposto il layout dei Panel di centro   

/*	*///	p_centro_1.setLayout(new GridLayout(2,1)); //Ho due oggetti che voglio posizionare uno sotto l'altro
	//	p_centro_1.setLayout(null);			 
	//	p_centro_1.add(jlbMenu); p_centro_1.add(CBmenu);
		p_centro_1.setLayout(new BorderLayout());
		p_centro_1.add(jlbMenu, BorderLayout.NORTH);
		p_centro_1.add(CBmenu, BorderLayout.SOUTH);

//		p_centro_1.add(jlbMenu, BorderLayout.EAST);
//		p_centro_1.add(CBmenu, BorderLayout.WEST);

		p_centro_2.add(BtnEsegui); p_centro_2.add(BtnEsci);

		p_centro_2.setLayout(null);           
		p_centro.setLayout(new GridLayout(2,1)); //Ho due Panel

// Imposto dimensione pulsanti, ma avrà effetto solo se imposto setLayout(null) per il Panel che li contiene! 
			Dimension BtnEseguiSize=BtnEsegui.getPreferredSize();
			BtnEsegui.setBounds(10, 10, BtnEseguiSize.width, BtnEseguiSize.height);
			Dimension BtnEsciSize=BtnEsci.getPreferredSize();
			BtnEsci.setBounds(15+ BtnEseguiSize.width, 10, BtnEsciSize.width, BtnEsciSize.height);
	
// Imposto il layout dei Panel di sotto   
/*
		p_sotto_1.setLayout(new BorderLayout());
	//	p_sotto_1.add(jlbMenu, BorderLayout.NORTH);
		p_sotto_1.add(CBmenu, BorderLayout.SOUTH);
*/

// Inizializzo il primo elemento della lista e imposto i Listener per la ComboBox  CBscelta 
		CBscelta.setSelectedIndex(0);
		CBscelta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox jcmbType = (JComboBox) e.getSource();
				String cmbType = (String) jcmbType.getSelectedItem();
				jlbPicture.setIcon(new ImageIcon("images/"
						+ cmbType.trim() + ".jpg"));
//						+ cmbType.trim().toLowerCase() + ".jpg"));
				String messaggio = "Foto' scelta: "+ cmbType.trim()+ "  "  + e.getActionCommand();
				JOptionPane.showMessageDialog(null, 
				messaggio, 
				"Conferma",
				JOptionPane.INFORMATION_MESSAGE);
				aggiornaDati(jcmbType.getSelectedIndex()); 
			}
		});

		// Imposta le immagini
		jlbPicture = new JLabel(new ImageIcon("images/"
//				+ sceltaStrings[CBscelta.getSelectedIndex()] + ".jpg"));
				+ CBscelta.getSelectedItem() + ".jpg"));
		jlbPicture.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		jlbPicture.setPreferredSize(new Dimension(400, 200 + 55));
		// Layout p_sotto_2_CBscelta
		p_sotto_2.setLayout(new BorderLayout());
		p_sotto_2.add(CBscelta, BorderLayout.NORTH);
		p_sotto_2.add(jlbPicture, BorderLayout.SOUTH);
//		p_sotto_2.add(CBscelta, BorderLayout.EAST);
//		p_sotto_2.add(jlbPicture, BorderLayout.WEST);
	//	p_sotto_2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


		pp.setLayout(new GridLayout(3,1)); //(verticale, Orizzontale) (y,x)

	//	f.add(p_sotto_1);
		f.add(p_sotto_2);
		f.setLayout(new GridLayout(2,1));
	//	f.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		
		f.pack(); // compatta gli elenti inseriti nella finestra
		
		f.setSize(600,600); //Uso i metodi ereditati dalla classe estesa, per impostare i parametri del frame.
		f.setBackground(Color.cyan); // imposto il colore di sfondo della finestra
		// Anche se con la tecnologia Jswing non è necessario, 
		//creo un "Listener" che permetterà di intercettare il click sulla casella di chiusura della finestra.
		f.addWindowListener( new CloseWindowAndExit() ); // creo un "Listener" che permetterà di intercettare il click sulla casella di chiusura della finestra.
		f.show(); // stesso effetto di f.setVisible(true); ma deprecata
		f.setVisible(true);
	}
	

  public void aggiornaDati(int i)    // Inizializzazzione dell'applicativo

	{ //sceltaStrings
		Voce v;
		v = (Voce) elenco.elementAt(i);
		nome.setText(v.nome); tel.setText(v.telefono); indirizzo.setText(v.indirizzo);
		compleanno.setText(v.compleanno); eta.setText(Integer.toString(v.eta));
	 }

	public  void BtnEsegui_mousePressed(MouseEvent e) {       // gestione del bottone ESEGUI
		JOptionPane.showMessageDialog (null," È stato premuto il pulsante Esegui.\n Questo messaggio è stato inviato dal metodo BtnEsegui_mousePressed.");
			System.out.println("Hai cliccato il pulsante Esegui.\n Questo messaggio è stato inviato dal metodo BtnEsegui_mousePressed.");
			esegui();
	}

	public  void BtnEsci_mousePressed(MouseEvent e) {       // gestione del bottone ESEGUI
		JOptionPane.showMessageDialog (null," È stato premuto il pulsante Esci. Il programma verrà terminato!\n Questo messaggio è stato inviato dal metodo BtnEsci_mousePressed.");
			System.out.println("Hai cliccato il pulsante Esci. Il programma verrà terminato!\n Questo messaggio è stato inviato dal metodo BtnEsci_mousePressed.");
      int n = JOptionPane.showConfirmDialog(null, 
                "Sei sicuro di voler uscire dal programma?", 
                "Uscita dal programma",
                JOptionPane.YES_NO_OPTION);
      if (n == JOptionPane.YES_OPTION)
      {
        System.exit(0);
      }
	}


	public  void esegui()  {       // gestione del bottone ESEGUI
    byte sc=(byte)CBmenu.getSelectedIndex();  // selezione del menu
		System.out.println(" sono in esegui()");
    switch(sc)  {
     case Aggiungi : { System.out.println(" Aggiungi voce"); Aggiungi(); break; }       // 1) Aggiungi voce
      case Elimina : { System.out.println(" Elimina voce");Elimina(); break;   // 2) Elimina voce
      }   // 2) Elimina voce
      case Aggiorna : { System.out.println(" Aggiorna rubrica");AggiornaRubrica(); break; }       // 3) Aggiorna rubrica
      case Stampa : { System.out.println(" Stampa rubrica");Stampa(); break; }       //4) Stampa rubrica (Stampa in terminal)
     }
	}
	public  void Aggiungi(){
			System.out.println("sono in Aggiungi voce");
			dialogFormManager.nome.setText(""); dialogFormManager.tel.setText(""); 
			dialogFormManager.indirizzo.setText("");
			dialogFormManager.compleanno.setText(""); dialogFormManager.eta.setText("");
			showDialog();
			if (dialogFormManager.EseguiBoolean){
				Voce v = new Voce();
				v.nome = dialogFormManager.nome.getText();
				v.telefono = dialogFormManager.tel.getText();
				v.indirizzo = dialogFormManager.indirizzo.getText();
				v.compleanno = dialogFormManager.compleanno.getText();
				v.eta = Integer.valueOf(dialogFormManager.eta.getText()).intValue();
				super.aggiungiVoce(v); //Aggiorno la rubrica
				initDati();  //Aggiorno elenco nella finestra principale
				CBscelta.setSelectedIndex(0);// Reimposto l'indice della ComboBox
				CBmenu.setSelectedIndex(0);// Reimposto l'indice della ComboBox
				}
		 }
	private void showDialog() {
			dialogFormManager.show();
		}
	public  void Elimina()
		{
			System.out.println("sono in  Elimina voce"); 
			eliminaVoce(CBscelta.getSelectedIndex());
		}
	public  void AggiornaRubrica(){
			System.out.println("sono in  Aggiorna rubrica");
			dialogFormManager.nome.setText(nome.getText()); dialogFormManager.tel.setText(tel.getText()); 
			dialogFormManager.indirizzo.setText(indirizzo.getText());
			dialogFormManager.compleanno.setText(compleanno.getText()); dialogFormManager.eta.setText(eta.getText());
			showDialog();
			if (dialogFormManager.EseguiBoolean){
				Voce v = new Voce();
				v.nome = dialogFormManager.nome.getText();
				v.telefono = dialogFormManager.tel.getText();
				v.indirizzo = dialogFormManager.indirizzo.getText();
				v.compleanno = dialogFormManager.compleanno.getText();
				v.eta = Integer.valueOf(dialogFormManager.eta.getText()).intValue();
				int n = JOptionPane.showConfirmDialog(null, 
						"Sei sicuro di voler aggiornare la voce: in posizione: "+
						(String) CBscelta.getSelectedItem()+
						" nell'elenco?", 
						"Aggiorna la voce",
						JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION){
						elenco.set(CBscelta.getSelectedIndex(), v); //Aggiorno vector elenco
						ScriviDati(); //Aggiorno il file
						initDati();  //Aggiorno elenco nella finestra principale
						CBscelta.setSelectedIndex(0);// Reimposto l'indice della ComboBox
						CBmenu.setSelectedIndex(0);// Reimposto l'indice della ComboBox
					}
				}
		}

	public  void Stampa(){
			System.out.println("sono in  Stamp rubrica");
			visualizza();
			CBmenu.setSelectedIndex(0);// Reimposto l'indice della ComboBox
		}

	public  void eliminaVoce(int indice)
	  {   Voce v;
		  v = (Voce) elenco.elementAt(indice);
		int n = JOptionPane.showConfirmDialog(null, 
                "Sei sicuro di voler eliminare la voce: "+v.nome+" dall'elenco?", 
                "Eliminare la voce",
                JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION)
		{ System.out.println("sono in  eliminaVoce e sto per chiamare super.eliminaVoce; elenco.size= "+elenco.size());
		  super.eliminaVoce(indice, "s");
			System.out.println("sono in  eliminaVoce e sto per chiamare initDati(); elenco.size= "+elenco.size());
		  sceltaStrings.removeElementAt(indice);//Rimuovo l'elemento dalla lista per non avere duplicati sull'ultimo della lista.
		  initDati(); //Riallinea il Vector degli oggetti con l'array delle scelte;
		  CBscelta.setSelectedIndex(0);// Reimposto l'indice della ComboBox
		  CBmenu.setSelectedIndex(0);// Reimposto l'indice della ComboBox
		}
     }

}

class CloseWindowAndExit extends WindowAdapter {
			public void windowClosing (WindowEvent e)
				{
				System.exit(0);
				}
}



class GestisciPulsanti implements ActionListener{
	public final static String ESEGUI = "ESEGUI";
	public final static String ESCI = "ESCI";

		public void actionPerformed(ActionEvent e){
			String com = e.getActionCommand();
			/*
			JButton b = (JButton)e.getSource();
			JOptionPane.showMessageDialog (null," È stato premuto "+b.getText());
			System.out.println("E' successo qualcosa!");
			System.out.println("L'etichetta del pulsante e': " +
			e.getActionCommand());
			*/
			if (com==ESEGUI) Click_OK();
			else if (com==ESCI) Click_ESCI();
	}
	private void Click_OK() {
		JOptionPane.showMessageDialog (null," È stato premuto il pulsante"+ESEGUI+"\n Questo messaggio è stato inviato da GestisciPulsanti.");
			System.out.println("Hai cliccato il pulsante "+ESEGUI+"\n Questo messaggio è stato inviato da GestisciPulsanti.");
		//	esegui(); // potrei fare qualche attività, come per esepio lanciare esegui().
	}
	private void Click_ESCI() {
		JOptionPane.showMessageDialog (null," È stato premuto il pulsante"+ESCI+"\n Questo messaggio è stato inviato da GestisciPulsanti.");
			System.out.println("Hai cliccato il pulsante "+ESCI+"\n Questo messaggio è stato inviato da GestisciPulsanti.");
	}

}
