package input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubmitButton extends JPanel implements ActionListener {

	JButton button;
	JLabel label;
	
	public SubmitButton() {
		super();
		button = new JButton("Submit");
		button.addActionListener(this);
		add(button);
		label = new JLabel("Birthday Submitted");
		label.setVisible(false);
		add(label);
	}

	public boolean isCorrect() {
		return true;
	}

	public void sumbittedSucessfully() {
		label.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isCorrect())
			sumbittedSucessfully();
		else
			button.setText("Incorrect Dateformat");
		
	}

}
