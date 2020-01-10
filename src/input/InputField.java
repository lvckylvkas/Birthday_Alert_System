package input;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InputField extends JPanel{
	
	JLabel label;
	JTextField text;
	
	public InputField(String s) {
		this.setVisible(true);
		label = new JLabel(s, SwingConstants.LEFT);
		add(label);
		text = new JTextField(15);
		add(text);
	}

}
