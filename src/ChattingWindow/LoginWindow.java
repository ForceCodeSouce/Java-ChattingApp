package ChattingWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.management.monitor.Monitor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JFrame {

	ImageIcon icon = new ImageIcon(
			"C:\\Users\\Force\\eclipse-workspace\\Java-ChattingApp\\src\\image\\simsonPeace.jpg");
	JPanel jpImage, jpFormId, jpFormPw, jpFormTotal, jpFormButton;
	JLabel jlId, jlPw, jlButton;
	JTextField jtId;
	JPasswordField jpPassword;
	JButton jbtnLogin, jbtnJoin;

	public void actionBackGround() {

		jpFormTotal = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		// 상단 이미지 패널
		jpImage = new JPanel(new FlowLayout(FlowLayout.CENTER)) {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				g.drawImage(icon.getImage(), 0, 0, null);
			}
		};
		jpImage.setBounds(0, 0, 450, 400);
		
		
		jpFormId = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jpFormId.add(jlId = new JLabel("ID    ", JLabel.RIGHT));
		jpFormId.add(jtId = new JTextField(30));
		
		jpFormPw = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jpFormPw.add(jlPw = new JLabel("PW ",JLabel.RIGHT));
		jpFormPw.add(jpPassword = new JPasswordField(30));
		
		jpFormButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jpFormButton.add(jbtnLogin = new JButton("Login"));
		jpFormButton.add(jbtnJoin = new JButton("Join"));
		
		
		jpFormTotal.add(jpFormId);
		jpFormTotal.add(jpFormPw);
		jpFormTotal.add(jpFormButton);
		jpFormTotal.setBounds(0, 400, 450, 550);
		
		
		//jpFormTotal.add(jpImage);
		//jpFormTotal.add(jpFormId);
		//jpFormTotal.add(jpFormPw);
		//this.add(jpFormTotal);
	
		this.add(jpImage);
		this.add(jpFormTotal);
		//this.add(jpFormId);
		//this.add(jpFormPw);

	}

	public LoginWindow() {

		setLayout(null);
		actionBackGround();
		this.pack();
		this.setSize(450, 600);
		this.setLocationRelativeTo(null); // 모니터 중앙에 위치하게 해주는 코드
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LoginWindow();
	}

}
