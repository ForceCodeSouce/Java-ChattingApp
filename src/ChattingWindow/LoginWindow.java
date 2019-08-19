package ChattingWindow;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.sampled.LineListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class LoginWindow extends JFrame implements ActionListener {

	ImageIcon icon = new ImageIcon(
			"C:\\Users\\Force\\eclipse-workspace\\Java-ChattingApp\\src\\image\\simsonPeace.jpg");
	JPanel jpImage, jpFormId, jpFormPw, jpFormTotal, jpFormButton;
	JLabel jlId, jlPw, jlButton;
	JTextField jtId;
	JPasswordField jpPassword;
	JButton jbtnLogin, jbtnJoin;

	public void actionBackGround() {

		// 화면구성
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
		jpFormPw.add(jlPw = new JLabel("PW ", JLabel.RIGHT));
		jpFormPw.add(jpPassword = new JPasswordField(30));

		jpFormButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jpFormButton.add(jbtnLogin = new JButton("Login"));
		jpFormButton.add(jbtnJoin = new JButton("Join"));

		jpFormTotal.add(jpFormId);
		jpFormTotal.add(jpFormPw);
		jpFormTotal.add(jpFormButton);
		jpFormTotal.setBounds(0, 400, 450, 550);

		// button function
		
		//마우스와 키보드 이벤트를 동시에 처리하는 핵심 코드
		//https://luvstudy.tistory.com/37 <-이 블로그 참조
		jbtnLogin.registerKeyboardAction(this, "Login", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);
		jbtnLogin.setActionCommand("Login");
		jbtnLogin.addActionListener(this);


		this.add(jpImage);
		this.add(jpFormTotal);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Login") {
			System.out.println("이벤트발생");
		}

	}

}
