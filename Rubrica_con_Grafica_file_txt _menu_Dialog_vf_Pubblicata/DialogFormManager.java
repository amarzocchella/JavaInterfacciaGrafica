import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DialogFormManager {
private JDialog dialog;
public  boolean EseguiBoolean;
		JPanel p_sopra=new JPanel(); 
		JPanel p_sopra_1=new JPanel(); 
		JPanel p_sopra_2=new JPanel(); 
// creo alcuni componenti da inserire sui Panel di sopra  
		JLabel  lb1  = new JLabel("Nome:"); JTextField nome= new JTextField();
		JLabel  lb2  = new JLabel("Tel."); JTextField tel= new JTextField();
		JLabel  lb3  = new JLabel("Indirizzo"); JTextField indirizzo= new JTextField();
		JLabel  lb4  = new JLabel("Compleanno (mm-gg)"); JTextField compleanno= new JTextField();
		JLabel  lb5  = new JLabel("Età"); JTextField eta= new JTextField();

public DialogFormManager(JFrame parent) {
dialog = new JDialog(parent, true);
dialog.setTitle("Dialog: Acquisizione dati");
JPanel buttons = new JPanel(new FlowLayout());
JButton BtnEsegui = new JButton("ESEGUI");
JButton BtnEsci = new JButton("ESCI");
// Imposto i Listener per i pulsanti
		BtnEsci.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(MouseEvent e) { BtnEsci_mousePressed(e);	}});

		BtnEsegui.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(MouseEvent e) { BtnEsegui_mousePressed(e);	}});

// Imposto dimensione pulsanti, ma avrà effetto solo se imposto setLayout(null) per il Panel che li contiene! 
			Dimension BtnEseguiSize=BtnEsegui.getPreferredSize();
			BtnEsegui.setBounds(10, 10, BtnEseguiSize.width, BtnEseguiSize.height);
			Dimension BtnEsciSize=BtnEsci.getPreferredSize();
			BtnEsci.setBounds(15+ BtnEseguiSize.width, 10, BtnEsciSize.width, BtnEsciSize.height);
/*
close.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
closeDialog();
}
});
*/
buttons.add(BtnEsegui); buttons.add(BtnEsci);

dialog.add(buttons, BorderLayout.SOUTH);
// inserisco i due pannelli p_sopra_1 e p_sopra_2 nel pannello p_sopra
		p_sopra.add(p_sopra_1);  p_sopra.add(p_sopra_2);
// Imposto il layout dei Panel di sopra   
    p_sopra.setLayout(new GridLayout(1,2));
    p_sopra_1.setLayout(new GridLayout(5,1));
    p_sopra_2.setLayout(new GridLayout(5,1));
// Inserisco i componenti sul Panel p_Dati
		p_sopra_1.add(lb1); p_sopra_2.add(nome);
		p_sopra_1.add(lb2); p_sopra_2.add(tel);
		p_sopra_1.add(lb3); p_sopra_2.add(indirizzo);
		p_sopra_1.add(lb4); p_sopra_2.add(compleanno);
		p_sopra_1.add(lb5); p_sopra_2.add(eta);

dialog.add(p_sopra, BorderLayout.NORTH);

dialog.setSize(200, 200);
dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
}

	public  void BtnEsegui_mousePressed(MouseEvent e) {       // gestione del bottone ESEGUI
		JOptionPane.showMessageDialog (null," È stato premuto il pulsante Esegui.\n Questo messaggio è stato inviato dal metodo BtnEsegui_mousePressed.");
			System.out.println("Hai cliccato il pulsante Esegui.\n Questo messaggio è stato inviato dal metodo BtnEsegui_mousePressed di dialogFormManager.");
			esegui();
			closeDialog();
	}

	public  void BtnEsci_mousePressed(MouseEvent e) {       // gestione del bottone ESEGUI
		JOptionPane.showMessageDialog (null," È stato premuto il pulsante Esci. L'operazione verrà Interrotta!\n Questo messaggio è stato inviato dal metodo BtnEsci_mousePressed.");
			System.out.println("Hai cliccato il pulsante Esci. Il programma verrà terminato!\n Questo messaggio è stato inviato dal metodo BtnEsci_mousePressed di dialogFormManager.");
      int n = JOptionPane.showConfirmDialog(null, 
                "Sei sicuro di voler uscire?", 
                "Uscita dal dialogFormManager",
                JOptionPane.YES_NO_OPTION);
      if (n == JOptionPane.YES_OPTION)
      { EseguiBoolean = false;
        closeDialog();
      }
	}

	private  void esegui()  {       // gestione del bottone ESEGUI
				EseguiBoolean = true;
		}
	
	public void show() {
			dialog.setVisible(true);
		}

	private void closeDialog() {
			dialog.dispose();
		}
}
