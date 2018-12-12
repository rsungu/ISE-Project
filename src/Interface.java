import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Interface {
	private JFrame f;
	private DisplayVeld modelnaam, feittype, feit, segment1, segment2, segmentDisplay, predikaat, realatie1, relatie2;
	private DisplayLabel modelnaamLabel, feittypeLabel, feitLabel, segment1Label, segment2Label;
	private JButton analyseinfoKnop, segment1Button, segment2Button, realatieToevoegenButton, predikaatButton;
	
	private boolean feitZichtbaar, segment1Zichtbaar, segment1KnopZichtbaar, segment2Zichtbaar, segment2KnopZichtbaar;
	
	public PopUp popUp;
	public FeitInvoeren Feit;
	public SegmentInvoeren Segment1, Segment2;
	
	//Coordinaten
	final private int fullWidthDisplay, halfWidthDisplay, heightDisplay;
	
	public Interface() {  
		f = new JFrame("Jan Pieters analysator"); 
		f.setSize(950, 800); 
		f.setResizable(false);
		feitZichtbaar = false;
		segment1KnopZichtbaar = false;
		fullWidthDisplay = f.getWidth()-100;
		halfWidthDisplay = (fullWidthDisplay/2) - 25;
		heightDisplay = 40;

		Setup();
		feitInvoeren();

		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}    
	
	private void feitInvoeren() {
		popUp.feit();
		
		feitZichtbaar = true;
		segment1KnopZichtbaar = true;
		PaginaLaden();
	}
	
	private void segment1Invoeren() {
		popUp.segment(0);
		segment1Zichtbaar = true;
		segment2KnopZichtbaar = true;
		PaginaLaden();
	}
	
	private void segment2Invoeren() {
		popUp.segment(1);
		segment2Zichtbaar = true;
		PaginaLaden();
	}
	
	private void Setup() {
		popUp = new PopUp();
		
		//PaginaLaden();
	}
	
	public void PaginaLaden() {
		analyseinfoTekenen();
		feitTekenen();
		segment1Tekenen();
		segment2Tekenen();
		
		//Relatie toevoegen button
		realatieToevoegenButton = new JButton();    
		realatieToevoegenButton.setText("Relatie toevoegen");
		realatieToevoegenButton.setBounds(segment1Button.getX(), segment1Button.getY() + segment1Button.getHeight() + 10, 200, 30);   
		
		//Predikaat genereren button
		predikaatButton = new JButton();    
		predikaatButton.setText("Predikaat genereren");
		predikaatButton.setBounds(realatieToevoegenButton.getX(), realatieToevoegenButton.getY() + realatieToevoegenButton.getHeight() + 10, 200, 30);   
		//f.add(predikaatButton);
		
//		//Predikaat
//		JLabel predikaatLabel = new JLabel();		
//		predikaatLabel.setText("Predikaat");
//		predikaatLabel.setBounds(50, 150, 850, 50);
//		f.add(predikaatLabel);
//		displayVeld predikaatText = new displayVeld(50, 185, 850, 60);
//		f.add(predikaatText);
//		
//		//Relatietype 1
//		JLabel relatie1Label = new JLabel();		
//		relatie1Label.setText("Relatietype 1");
//		relatie1Label.setBounds(50, 230, 850, 50);
//		f.add(relatie1Label);
//		displayVeld relatie1Text = new displayVeld(50, 265, 850, 60);
//		f.add(relatie1Text);
//		
//		//Relatietype 2
//		JLabel relatie2Label = new JLabel();		
//		relatie2Label.setText("Relatietype 2");
//		relatie2Label.setBounds(50, 310, 850, 50);
//		f.add(relatie2Label);
//		displayVeld relatie2Text = new displayVeld(50, 345, 850, 60);
//		f.add(relatie2Text);
		
		f.revalidate();
		f.repaint();
	}
	
	private void analyseinfoTekenen() {
		//Model naam
		modelnaamLabel = new DisplayLabel();		
		modelnaamLabel.setText("Modelnaam:");
		modelnaamLabel.setBounds(50, 0, halfWidthDisplay, heightDisplay);
		modelnaam = new DisplayVeld();
		modelnaam.setBounds(modelnaamLabel.getX(), modelnaamLabel.getY() + modelnaamLabel.getHeight(), halfWidthDisplay, heightDisplay);
		modelnaam.setText(popUp.getModelNaam());
		f.add(modelnaamLabel);
		f.add(modelnaam);
		
		//Feittype
		feittypeLabel = new DisplayLabel();		
		feittypeLabel.setText("Feittype:");
		feittypeLabel.setBounds(modelnaamLabel.getX() + modelnaamLabel.getWidth() + 50, modelnaamLabel.getY(), halfWidthDisplay, heightDisplay);
		feittype = new DisplayVeld();
		feittype.setBounds(feittypeLabel.getX(), feittypeLabel.getY() + feittypeLabel.getHeight(), halfWidthDisplay, heightDisplay);
		feittype.setText(popUp.getFeittype());
		
		f.add(feittypeLabel);
		f.add(feittype);
		
		analyseinfoKnop = new JButton();    
		analyseinfoKnop.setText("Info aanpassen");
		analyseinfoKnop.setBounds(modelnaam.getX(), modelnaam.getY() + modelnaam.getHeight(), 160, 30);   
		//EventListener segment1Button
		analyseinfoKnop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				feitInvoeren();
					}
			});
		f.add(analyseinfoKnop);
	}
	
	private void feitTekenen() {
		//Feit
		feitLabel = new DisplayLabel();
		feitLabel.setText("Het feit");
		feitLabel.setBounds(analyseinfoKnop.getX(), analyseinfoKnop.getY() + analyseinfoKnop.getHeight(), fullWidthDisplay, heightDisplay);
		feit = new DisplayVeld();	
		feit.setBounds(feitLabel.getX(), feitLabel.getY() + feitLabel.getHeight(), fullWidthDisplay, heightDisplay);
		feit.setText(popUp.getFeitTekst());
		
//		feitButton = new JButton();    
//		feitButton.setText("Feit aanpassen");
//		feitButton.setBounds(feit.getX(), feit.getY() + feit.getHeight(), 160, 30);   
//		//EventListener segment1Button
//		feitButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				feitInvoeren();
//					}
//			});
		
		if (feitZichtbaar) {
			f.add(feitLabel);
			f.add(feit);
			//f.add(feitButton);
		}
	}

	private void segment1Tekenen() {
		//Segment 1
		segment1Label = new DisplayLabel();		
		segment1Label.setText("Segment 1");
		//segment1Label.setBounds(feitButton.getX(), feitButton.getY() + feitButton.getHeight(), halfWidthDisplay, heightDisplay);
		segment1Label.setBounds(analyseinfoKnop.getX(), feit.getY() + feit.getHeight(), halfWidthDisplay, heightDisplay);
		segment1 = new DisplayVeld();
		segment1.setBounds(segment1Label.getX(), segment1Label.getY() + segment1Label.getHeight(), halfWidthDisplay, heightDisplay * 2);
		System.out.println(popUp.generateSegment(0));
		segment1.setText(popUp.generateSegment(0));
		//Segment 1 aanpassen button
		segment1Button = new JButton();    
		segment1Button.setText("Segment toevoegen");
		segment1Button.setBounds(segment1.getX(), segment1.getY() + segment1.getHeight(), 160, 30);   
		//EventListener segment1Button
		segment1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				segment1Invoeren();
					}
			});
		if (segment1KnopZichtbaar && !segment1Zichtbaar) {
			f.add(segment1Label);
			f.add(segment1Button);
		}
		if (segment1Zichtbaar) {
			f.add(segment1Label);
			f.add(segment1);
			//Tekst word nog niet veranderd
			segment1Button.setText("Segment aanpassen");
			f.add(segment1Button);
		}
	}
	
	private void segment2Tekenen() {
		//Segment 2
		segment2Label = new DisplayLabel();		
		segment2Label.setText("Segment 2");
		segment2Label.setBounds(segment1Label.getX() + segment1Label.getWidth() + 50, feit.getY() + feit.getHeight(), halfWidthDisplay, heightDisplay);
		segment2 = new DisplayVeld();
		segment2.setBounds(segment2Label.getX(), segment2Label.getY() + segment2Label.getHeight(), halfWidthDisplay, heightDisplay * 2);
		segment2.setText(popUp.getSegmentString()[1]);
		//Segment 2 aanpassen button
		segment2Button = new JButton();    
		segment2Button.setText("Segment toevoegen");
		segment2Button.setBounds(segment2.getX(), segment2.getY() + segment2.getHeight(), 160, 30);   
		//EventListener segment2Button
		segment2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				segment2Invoeren();
					}
			});
		if (segment2KnopZichtbaar && !segment2Zichtbaar) {
			f.add(segment2Label);
			f.add(segment2Button);
		}
		if (segment2Zichtbaar) {
			f.add(segment2Label);
			f.add(segment2);
			//Tekst word nog niet veranderd
			segment2Button.setText("Segment aanpassen");
			f.add(segment2Button);
		}
	}

	public static void main(String[] args) {    
	    new Interface();    
	}    
 }