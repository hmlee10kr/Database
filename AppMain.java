package pro;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dimension dim = new Dimension(1600,800);

		JFrame frame = new JFrame("CAMPING CAR");// 게임 제목과 프레임 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 프레임에 x버튼을 눌렀을 때 종료
		
		frame.setResizable(false);// 고정크기로 실행

		AppMainPanel pan = new AppMainPanel(); // 패널 생성

		frame.getContentPane().add(pan);// 프레임에 패널 추가

		// 화면에 프레임 표시
		frame.setPreferredSize(dim);
		frame.pack();
		frame.setVisible(true);
	}// driver class application

}