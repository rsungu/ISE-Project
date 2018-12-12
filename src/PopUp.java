import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PopUp {	
	private JComboBox<String>[] invoerID;
	
	private String FeitTekst, ModelNaam, Feittype;
	private String 	EtOfAtt[] = new String[2],
					Naam[] = new String[2],
					segmentString[] = new String[2],
					ID[] = new String[10];
	private int aantalID;
	
	PopUp() {
		invoerID = new JComboBox[10];
		invoerID[0] = new JComboBox<String>();
		//Items toevoegen
		invoerID[0].addItem("Test");
		invoerID[0].addItem("Moet uit database worden opgehaald");
		invoerID[0].setBackground(Color.WHITE);
		invoerID[0].setEnabled(true);
		
		segmentString[0] = "";
		segmentString[1] = "";
		ModelNaam = "";
		Feittype = "";
		FeitTekst = "";
		aantalID = 1;
		
		//feit();
	}
	
	public void feit() {
		DisplayVeld modelnaam = new DisplayVeld();
		modelnaam.setText(ModelNaam);
		modelnaam.setEditable(true);
		DisplayVeld feittype = new DisplayVeld();
		feittype.setText(Feittype);
		feittype.setEditable(true);
		DisplayVeld feit = new DisplayVeld();
		feit.setText(FeitTekst);
		feit.setEditable(true);
		
		Object[] input = {
				"Voer de naam van het model in.", modelnaam,
				"Feittype:", feittype,
				"Voer het feit in dat u wilt analyseren.", feit
		};
		
		Object[] buttons = {
				"Opslaan"
		};
	
		int buttonPressed = JOptionPane.showOptionDialog(null, input, "Feit invoeren", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);

        switch (buttonPressed) {
        case 0:
    		ModelNaam = modelnaam.getText();
    		Feittype = feittype.getText();
    		FeitTekst = feit.getText();
    		//segment(0);
            break;
        } 
	}
	
	public void segment(int segmentNummer) {
		//Segment selecteren
		DisplayVeld selectVeld = new DisplayVeld();
		selectVeld.setSelectedTextColor(Color.red);
		selectVeld.setEditable(false);
		selectVeld.setText(FeitTekst);
		
		DisplayVeld segment = new DisplayVeld();
		segment.setSelectionColor(null);
		segment.setEditable(false);
		segment.setText(segmentString[segmentNummer]);
		//EventListener display
		selectVeld.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if (selectVeld.getSelectedText() != null) {
					segment.setText(selectVeld.getSelectedText());
				}	
			}
		});
		
		//Entiteit of attribuut
		JComboBox<String> invoerEtOfAtt = new JComboBox<String>();
		//Items toevoegen
		invoerEtOfAtt.addItem("ET");
		invoerEtOfAtt.addItem("Att");
		invoerEtOfAtt.setBackground(Color.WHITE);
		//invoerEtOfAtt.setSelectedIndex(0);
		invoerEtOfAtt.setEnabled(true);
		
		//Naam kiezen
		DisplayVeld naam = new DisplayVeld();
		naam.setEditable(true);
		naam.setText(Naam[segmentNummer]);
			
		//Component vorige button
		JButton idToevoegen = new JButton();    
		idToevoegen.setText("+");
		if (aantalID < 10) {
			idToevoegen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) { 
					System.out.println(aantalID);
					aantalID++;
					invoerID[aantalID] = new JComboBox<String>();
					
					//Items toevoegen 
					//Moet uit database opgehaald worden
					invoerID[aantalID].addItem("Test");
					invoerID[aantalID].addItem("Moet uit database worden opgehaald");
					
					invoerID[aantalID].setBackground(Color.WHITE);
					invoerID[aantalID].setEnabled(true);
					
					segmentString[segmentNummer] = segment.getText();
	            	EtOfAtt[segmentNummer] = (String) invoerEtOfAtt.getSelectedItem();
	            	Naam[segmentNummer] = naam.getText();
					
					segment(segmentNummer);
				}
			});
		}
		
		
		//Component vorige button
		JButton idVerwijderen = new JButton();    
		idVerwijderen.setText("-");
		if (aantalID > 0) {
			idVerwijderen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) { 
					System.out.println(aantalID);
					aantalID--;
					invoerID[aantalID] = null;					
					
					segmentString[segmentNummer] = segment.getText();
	            	EtOfAtt[segmentNummer] = (String) invoerEtOfAtt.getSelectedItem();
	            	Naam[segmentNummer] = naam.getText();
	            	
	            	segment(segmentNummer);
				}
			});
		}
		
		Object[] input = {
				"Selecteer het segment:", selectVeld,
				"Uw geselecteerde segment:", segment,
				"Entiteit of Attribuut?", invoerEtOfAtt,
				"Naam:", naam,
				"ID:", invoerID,
				idVerwijderen,
				idToevoegen
				
		};

		Object[] buttons = {
				"Annuleren",
				"Opslaan"
		};
		
        int buttonPressed = JOptionPane.showOptionDialog(null, input, "Segment selecteren", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);
        
        switch (buttonPressed) {
            case 0:
                //feit();
                break;
            case 1:
            	segmentString[segmentNummer] = segment.getText();
            	EtOfAtt[segmentNummer] = (String) invoerEtOfAtt.getSelectedItem();
            	Naam[segmentNummer] = naam.getText();
            	for (int i = 0; i < aantalID; i++) {
            		ID[i] = (String) invoerID[i].getSelectedItem();
            	}
            	break;
        }
	}
	
	public String generateSegment(int segmentNummer) {
		boolean first = true;
		String segment = segmentString[segmentNummer] + "\n";
		segment += EtOfAtt[segmentNummer] + " " + Naam[segmentNummer] + "\n" + "ID: ";
    	for (int i = 0; i < aantalID; i++) {
    		if (aantalID == 1 || first) {
    			first = false;
    			segment += ID[i];
    		} else {
    			segment += " + " + ID[i];
    		}
    	}
		return segment;
	}	

	
	public String getFeittype() {
		return Feittype;
	}

	public void setFeittype(String feittype) {
		Feittype = feittype;
	}

	public JComboBox<String>[] getInvoerID() {
		return invoerID;
	}

	public void setInvoerID(JComboBox<String>[] invoerID) {
		this.invoerID = invoerID;
	}

	public String getFeitTekst() {
		return FeitTekst;
	}

	public void setFeitTekst(String feitTekst) {
		FeitTekst = feitTekst;
	}

	public String getModelNaam() {
		return ModelNaam;
	}

	public void setModelNaam(String modelNaam) {
		ModelNaam = modelNaam;
	}

	public String[] getEtOfAtt() {
		return EtOfAtt;
	}

	public void setEtOfAtt(String[] etOfAtt) {
		EtOfAtt = etOfAtt;
	}

	public String[] getNaam() {
		return Naam;
	}

	public void setNaam(String[] naam) {
		Naam = naam;
	}

	public String[] getSegmentString() {
		return segmentString;
	}

	public void setSegmentString(String[] segmentString) {
		this.segmentString = segmentString;
	}

	public String[] getID() {
		return ID;
	}

	public void setID(String[] iD) {
		ID = iD;
	}

	public int getAantalID() {
		return aantalID;
	}

	public void setAantalID(int aantalID) {
		this.aantalID = aantalID;
	}
	
}
