package pro;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dimension dim = new Dimension(1600,800);

		JFrame frame = new JFrame("CAMPING CAR");// ���� ����� ������ ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �����ӿ� x��ư�� ������ �� ����
		
		frame.setResizable(false);// ����ũ��� ����

		AppMainPanel pan = new AppMainPanel(); // �г� ����

		frame.getContentPane().add(pan);// �����ӿ� �г� �߰�

		// ȭ�鿡 ������ ǥ��
		frame.setPreferredSize(dim);
		frame.pack();
		frame.setVisible(true);
	}// driver class application

}