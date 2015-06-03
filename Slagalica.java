package com.jelena.slagalica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//RESAVAJ BROJ SLOVA, TACNO 12, PROVERAVAJ STA JE UKUCAO U REC I UPOZORENJE AKO JE UPOTREBLJENO NEKO SLOVO KOJE NE MOZE
//KAKO SE RADI SA NASIM SLOVIMA, snimila kao utf-8 kad mi je ponudio
public class Slagalica extends JPanel implements ActionListener {
	JLabel lblSlova = new JLabel();
	JTextField txtVasaRec = new JTextField("");;
	JButton btnObrisiSlovo = new JButton("<--");
	JButton btnKraj = new JButton("KRAJ");//("\u00DF");
	ButtonSlovo[] nizSlova = new ButtonSlovo[12];
	
	public Slagalica(String rec){ //rec mora imati 12 ili manje slova, ako ima manje dodati u listu neka slova po slucajnom izboru		
		lblSlova.setText(rec);
		ArrayList<Character> list = new ArrayList<Character>();
        for (int i=0; i<rec.length(); i++) { 
            list.add(rec.charAt(i));
        }
        
        for (int i=rec.length(); i<12; i++) {
        	 final String alphabet = "ABCČĆDĐEFGHIJKLMNOPRSŠTUVZŽжжжжжжжжжжжжжжжжжжжжжжжжж";
             final int N = alphabet.length();
             Random r = new Random();
             list.add(alphabet.charAt(r.nextInt(N)));                
        }
        
        Collections.shuffle(list);
        
        for (int i=0; i<12; i++) {
            nizSlova[i]= new ButtonSlovo(list.get(i));//cudno opet new     
        }
		
		inic();					
	}
	
	public void inic(){
		setLayout(null);
		lblSlova.setBounds(210, 50, 100, 50);
		btnObrisiSlovo.setBounds(500,100,50,50);
		txtVasaRec.setBounds(210, 100, 250, 50);
		btnKraj.setBounds(150, 200, 150, 50);
				
		btnKraj.addActionListener(this);
		btnObrisiSlovo.addActionListener(this);
		
		add(lblSlova);
		for (int i=0; i<12; i++) {
			nizSlova[i].setBounds(50*i+10, 10 , 50, 50);//moram ovo jer mi layout null, sve se rucno podesava
			add(nizSlova[i]);
			nizSlova[i].addActionListener(this);
		}
		add(txtVasaRec);
		add(btnObrisiSlovo);	
		add(btnKraj);		
		
	}
	
	public void actionPerformed (ActionEvent e) {
		String sa= e.getActionCommand(); 
		
		if (sa.equals("KRAJ")) {
			if ( txtVasaRec.getText().equals("češkanje"  ) ) {
				JOptionPane.showMessageDialog(null, "Vi ste kao kompjuter!", "Poruka", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Pozovite Milku Canić da presudi", "Poruka", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {		
			if (sa.equals("<--")) { //obrisi slovo
				obrisiSlovo();
			}				
			else{
				JButton btnClicked = (JButton) e.getSource(); // a ovo ne izbacuje taj exception
				//ButtonSlovo btnClicked = (ButtonSlovo)e.getSource(); //ovo izbaci na karaju progrmaa exception, cast to ButtonSLovo imposible???
				String s = btnClicked.getText();				
				String sn = txtVasaRec.getText();
				sn = sn.concat(s);			
				txtVasaRec.setText(sn);
			}
		}
		
	}
	
	public void obrisiSlovo(){
		String s = txtVasaRec.getText();
		if (!s.equals("")){
			String snew = s.substring(0, s.length()-1);
			txtVasaRec.setText(snew);
		}	
	}
	
	
/*	public String smuckajSlova(String rec) {
		
		ArrayList<Character> list = new ArrayList<Character>();
        for (int i=0; i<rec.length()-1; i++) { 
            list.add(rec.charAt(i));
        }
        Collections.shuffle(list); //shuffle randomly permutes the specified list 
        for (int i=0; i<rec.length()-1; i++) {
            System.out.println(list.get(i));
        }
	//ubaci muckanje, treba dodati neka slova da bude 12 slova, trebao bi mi StringBuilder
		return rec;
	}*/
	


}
