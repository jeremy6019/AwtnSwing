package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabelFrame extends JFrame {
	JLabel lbl;
	ImageIcon [] images;
	Thread th1;
	ImageIcon [] su;
	int x = 0;
	
	public LabelFrame() {
		setLayout(new FlowLayout());
		//ImageIcon 배열 만들기
		images = new ImageIcon[3];
		images[0] = new ImageIcon("./80006.png");
		images[1] = new ImageIcon("./80015.png");
		images[2] = new ImageIcon("./80016.png");
		
		//현재 디렉토리 경로를 확인
		String curDir = System.getProperty("user.dir");
		System.out.printf("%s\n", curDir);
		
		//절대 경로를 이용해서 ImageIcon을 생성
		//Windows의 절대 경로는 디렉토리기호가 \\
		/*
		ImageIcon icon = 
			new ImageIcon(
			"/Users/a503_18/Downloads/idol1.png");
		*/
		
		//상대경로 이용
		/*
		ImageIcon icon = 
				new ImageIcon(
				"../idol1.png");
				*/
		//이미지 아이콘을 이용해서 레이블을 생성

		lbl = new JLabel(images[0]);
		add(lbl);	
		
		Thread th = new Thread() {
			int idx = 0;
			public void run() {
				while(true) {
					try {
						idx = idx + 1;
						Thread.sleep(100);
						lbl.setIcon(
							images[idx%images.length]);
					}
					catch(Exception e) {}
				}
			}
		};
	//	th.start();
		
		//닫기 버튼을 누를 때 종료 기능을 수행하도록 설정
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		
		JButton start = 
				new JButton("시작");
		add(start);
		
		JButton end = new JButton("멈춤");
		add(end);
		
		end.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				th1.interrupt();
				System.out.println(x);
				
			}
			
		});
		
		this.setBounds(100,100, 1000,1000);
		this.setTitle("레이블 애니메이션");
		this.setVisible(true);
		
		su = new ImageIcon[10];
		for(int i=0; i<10; i=i+1) {
			su[i] = 
				new ImageIcon("./" + i + ".png");
		}
		
		
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				th1 = new Thread() {
					public void run() {
						while(true) {
							try {
								Thread.sleep(100);
								Random r = new Random();
								x = r.nextInt(10);
								lbl.setIcon(su[x]);
							}catch(Exception e1) {
								return;
							}
						}
					}
				};
				th1.start();
			}
		});
		
		
		
	}
}





