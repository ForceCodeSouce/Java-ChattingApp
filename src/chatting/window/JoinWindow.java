package chatting.window;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import chatting.dao.ChattingDao;

public class JoinWindow extends JFrame implements ActionListener {

	JPanel jpTotal, jpId, jpPw, jpPwCon, jpName, jpNick, jpButton;
	JLabel jlId, jlPw, jlPwCon, jlName, jlNick;
	JTextField jtId, jtName, jtNick;
	JPasswordField jpPass, jpPassCon;
	JButton jbtnOk, jbtnCancel, jbtnIdCheck;

	public void JoinWindowPopup() {
		jpTotal = new JPanel(new GridLayout(6, 1));
		// jpTotal = new JPanel(new FlowLayout(FlowLayout.CENTER));

		jpId = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpId.add(jlId = new JLabel("ID                ", JLabel.RIGHT));
		jpId.add(jtId = new JTextField(20));
		jpId.add(jbtnIdCheck = new JButton("ID Check"));
		jpTotal.add(jpId);

		jpPw = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPw.add(jlPw = new JLabel("PW             ", JLabel.RIGHT));
		jpPw.add(jpPass = new JPasswordField(20));
		jpTotal.add(jpPw);

		jpPwCon = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPwCon.add(jlPwCon = new JLabel("PW Check", JLabel.RIGHT));
		jpPwCon.add(jpPassCon = new JPasswordField(20));
		jpTotal.add(jpPwCon);

		jpName = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpName.add(jlName = new JLabel("NAME         "));
		jpName.add(jtName = new JTextField(20));
		jpTotal.add(jpName);

		jpNick = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpNick.add(jlNick = new JLabel("NICK           "));
		jpNick.add(jtNick = new JTextField(20));
		jpTotal.add(jpNick);

		jpButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jpButton.add(jbtnOk = new JButton("OK"));
		jpButton.add(jbtnCancel = new JButton("Cancel"));
		// jpButton.setBounds(420, 400, 420, 100);
		jpTotal.add(jpButton);

		this.add(jpTotal);

		// 이벤트 처리를 하는 코드 구현
		// ID Check에 대한 엔터키와 마우스 이벤트 처리
		jtId.registerKeyboardAction(this, "ID Check", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);
		jbtnIdCheck.setActionCommand("ID Check");
		jbtnIdCheck.addActionListener(this);

		jtNick.registerKeyboardAction(this, "OK", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);
		jbtnOk.setActionCommand("OK");
		jbtnOk.addActionListener(this);

		// Cancel 버튼에 대한 Enter키와 Mouse 이벤트 처리
		jbtnCancel.registerKeyboardAction(this, "Cancel", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);
		jbtnCancel.setActionCommand("Cancel");
		jbtnCancel.addActionListener(this);
	}

	public JoinWindow() {
		super("MemberJoin");
		JoinWindowPopup();
		// this.setSize(420, 450);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand() == "ID Check") {
			System.out.println("아이디 체크 이벤트 발생");
		}

		if (e.getActionCommand() == "OK") {

			// JPasswordField 이 부분을 어떻게 처리해야 될지 모르겠다.
			// GetText로 가져오는게 막혀버렸으니...
			/*
			 * ChattingMember member = new ChattingMember();
			 * 
			 * member.setId(jtId.getText()); member.setName(jtName.getName());
			 * member.setPassword(jpPass.getToolTipText());
			 * member.setNickName(jtNick.getText());
			 */
			ChattingDao.InsertMember(jtId.getText(), jtName.getText(), jpPass.getPassword(), jtNick.getText());
			this.dispose(); // 취소 이벤트 처리 완료!!!
			System.out.println("회원가입 완료");
		}

		if (e.getActionCommand() == "Cancel") {
			System.out.println("취소 이벤트 발생");
			this.dispose(); // 취소 이벤트 처리 완료!!!
		}

	}

}
