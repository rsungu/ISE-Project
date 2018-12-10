import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Interface {
	private JFrame f;
	private DisplayVeld feit, segment1, segment2, segmentDisplay, predikaat, realatie1, relatie2;
	
	public PopUp popUp;
	public FeitInvoeren Feit;
	public SegmentInvoeren Segment1, Segment2;
	
	//Coordinaten
	final private int xDisplay, fullWidthDisplay, halfWidthDisplay, heightDisplay;
	
	
	public Interface() {  
		f = new JFrame("Jan Pieters analysator"); 
		f.setSize(950, 800); 
		f.setResizable(false);
		
		xDisplay = 50;
		fullWidthDisplay = f.getWidth()-100;
		halfWidthDisplay = (fullWidthDisplay/2) - 25;
		heightDisplay = 60;

		Setup();
		PaginaLaden();
		Feit.PaginaLaden();

		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}    
	
	private void Setup() {
		popUp = new PopUp();
		Feit = new FeitInvoeren();
		Segment1 = new SegmentInvoeren(1, f, this);
		Segment2 = new SegmentInvoeren(2, f, this);
		
		Feit.variabelenToevoegen(Segment1, Segment2);
		Segment1.variabelenToevoegen(Feit, Segment2);
		Segment2.variabelenToevoegen(Feit, Segment1);		
	}
	
	public void PaginaLaden() {
		//Feit
		JLabel feitLabel = new JLabel();
		feitLabel.setText("Het feit");
		feitLabel.setBounds(xDisplay, 0, fullWidthDisplay, heightDisplay);
		f.add(feitLabel);
		feit = new DisplayVeld();	
		feit.setBounds(xDisplay, feitLabel.getY() + heightDisplay, fullWidthDisplay, heightDisplay);
		feit.setText(popUp.getFeitTekst());
		f.add(feit);
		
		//Segment 1
		JLabel segment1Label = new JLabel();		
		segment1Label.setText("Segment 1");
		segment1Label.setBounds(xDisplay, feit.getY() + heightDisplay, halfWidthDisplay, heightDisplay);
		f.add(segment1Label);
		segment1 = new DisplayVeld();
		segment1.setBounds(xDisplay, segment1Label.getY() + heightDisplay, halfWidthDisplay, heightDisplay * 2);
		segment1.setText(popUp.getSegmentString(0));
		f.add(segment1);
		
		//Segment 1 aanpassen button
		JButton segment1Button = new JButton();    
		segment1Button.setText("Segment aanpassen");
		segment1Button.setBounds(segment1.getX(), segment1.getY() + segment1.getHeight(), 160, 30);   
		f.add(segment1Button);
		//EventListener segment1Button
		segment1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Test");
				popUp.segment(0);
					}
			});
		
		//Segment 2
		JLabel segment2Label = new JLabel();		
		segment2Label.setText("Segment 2");
		segment2Label.setBounds(xDisplay + segment1Label.getWidth() + 50, feit.getY() + feit.getHeight(), halfWidthDisplay, heightDisplay);
		f.add(segment2Label);
		segment2 = new DisplayVeld();
		segment2.setBounds(segment2Label.getX(), segment2Label.getY() + segment2Label.getHeight(), halfWidthDisplay, heightDisplay * 2);
		segment2.setText(popUp.getSegmentString(1));
		f.add(segment2);	
		
		//Segment 2 aanpassen button
		JButton segment2Button = new JButton();    
		segment2Button.setText("Segment aanpassen");
		segment2Button.setBounds(segment2.getX(), segment2.getY() + segment2.getHeight(), 160, 30);   
		f.add(segment2Button);
		//EventListener segment2Button
		segment2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				popUp.segment(1);
					}
			});
		
		
		//Relatie toevoegen button
		JButton realatieToevoegenButton = new JButton();    
		realatieToevoegenButton.setText("Relatie toevoegen");
		realatieToevoegenButton.setBounds(segment1Button.getX(), segment1Button.getY() + segment1Button.getHeight() + 10, 200, 30);   
		//f.add(realatieToevoegenButton);
		
		//Predikaat genereren button
		JButton predikaatButton = new JButton();    
		predikaatButton.setText("Predikaat genereren");
		predikaatButton.setBounds(realatieToevoegenButton.getX(), realatieToevoegenButton.getY() + realatieToevoegenButton.getHeight() + 10, 200, 30);   
		//f.add(predikaatButton);
//		
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
//		
		f.revalidate();
		f.repaint();
	}
	
	public static void main(String[] args) {    
	    new Interface();    
	}    
 }