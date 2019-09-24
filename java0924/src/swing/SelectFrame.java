package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SelectFrame extends JFrame {
        JComboBox oop;
        JList lang;
        
        //ComboBox 와 JList에 데이터를 추가하기 위한 배열 
        String[] ar;
        String[] br;
        
        //버튼 
        JButton btn;
        
        //테이블 
        JTable table;
        
        //입력한 번호를 저장할 변수 
        int idx =2;        
        JTextField txtName;
		//이름 과 전화번호를 입력할 텍스트 필드 
        JTextField txtPhone;       
        //나이를 선택할 콤보박스 
        JComboBox cbAge;       
        //삽입과 삭제를 위한 버튼 
        JButton btnInsert, btnDelete;
        
		public SelectFrame() {
	        int[] month = 
	        	{0, 31,28,31,30,31,30,31,31,30,31,30,31};
	        
			ar = new String[4]; 
			ar[0] = "----";
			ar[1] = "encapsulation=캡슐화";
			ar[2] = "Inheritace-상속성";
			ar[3] = "Polymorphism -다형성";
			
		    br = new String[4]; 
		    br[0] ="Java";
		    br[1] = "Javascript";
		    br[2] = "SQL";
		    br[3] = "Swift";
		    
		    oop = new JComboBox(ar); 
		    lang = new JList(br); 
		    btn = new JButton("확인");
		    
		    JPanel panel = new JPanel(); 
		    panel.add(oop);
		    panel.add(lang);
		    panel.add(btn);		
		    
		    add("North",panel);
		    
		    //btn을 누르면 oop에서 선택한 항목과 lang에서 선택한 
		    //항목을 콘솔에 출력 
		    btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) 
				{				   
					//콤보박스에서 선택한 항목의 인덱스를 찾아오기 
					int idx = oop.getSelectedIndex();  
					//리스트에서 선택한 항목의 인덱스 집합 찾아오기 
					int[] idxes = lang.getSelectedIndices();
				   
					System.out.printf("콤보박스 선택:%s\n", ar[idx]);
					System.out.printf("===================\n");
					for( int i : idxes) {
						System.out.printf("%s\n", br[i]);
					}
					
				}
		    	
		    });
		    
		    //테이블에 출력할 데이터 배열을 생성 
		    String[] headers = 
		    	{"번호", "이름", "나이", "전화번호"};
		    String[][] datas = {
		    		{"1","김기범", "45","010-5038-6578"},
		    		{"2","이은영", "39", "010-9365-7051"},
		    		{"3","김윤서", "10", "010-2246-6578"}};
		    
		    //데이터 배열을 가지고 테이블에 출력할 모델을 생성 
		    DefaultTableModel model =
		    		new  DefaultTableModel(datas, headers);
           		    
		   //테이블을 생성 
		    table =new JTable(model);
		    
		    //테이블은 스크롤 가능한 Pane위에 출력해야 합니다. 
		    JScrollPane sc = new JScrollPane(table);
		    add(sc);
		    
		    JLabel lblName = new JLabel("이름"); 
		    txtName = new JTextField(10);
		    JLabel lblAge = new JLabel("나이"); 
		    String[] arAge = new String[100]; 
		    for(int i=0; i<100; i+=1) {
		    	arAge[i] = String.format("%d", i+1 );
		    }
		    cbAge = new JComboBox(arAge);
		    
		    JLabel lblPhone = new JLabel("전화번호"); 
		    txtPhone = new JTextField(15);
		    
		    btnInsert = new JButton("추가");
		    btnDelete = new JButton("삭제");
		    
		    JPanel southPanel = new JPanel(); 
		    southPanel.add(lblName);
		    southPanel.add(txtName);
		    southPanel.add(lblAge);
		    southPanel.add(cbAge);
		    southPanel.add(lblPhone);
		    southPanel.add(txtPhone);
		    southPanel.add(btnInsert);
		    southPanel.add(btnDelete);
		    
		    add("South", southPanel); 
		    
		    btnInsert.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					//입력한 내용 전부 가져오기 
					String name = txtName.getText(); 
					int age = cbAge.getSelectedIndex()+1;
					String phone = txtPhone.getText();
					
					//name은 좌우 공백없이 3자이상 
					if(name.trim().length() < 3) {
						JOptionPane.showMessageDialog(
								null, "이름은 3자 이상 필수 입력");
						return;
					}
					
					//phone필수 입력 
					if(phone.trim().length() < 1) {
						JOptionPane.showMessageDialog(
								null, "전화번호는 필수 입력");
						return;
					}
					
					//JTable은 MVC패턴으로 구현 
					//JTable은 화면에 출력되는 부분만 제어 
					//데이터 삽입과 삭제는 모델이 수행 
				   DefaultTableModel model =
						   (DefaultTableModel)table.getModel();
				   idx += 1;
				    String[] row = {idx+"",name.trim(), 
				    		age+"", phone.trim()
				    };
				    //데이터 추가 
					model.addRow(row);
					JOptionPane.showMessageDialog(
							null, "추가 성공");
					
					//입력 도구 들을 초기화 
					txtName.setText("");
					cbAge.setSelectedIndex(0);
					txtPhone.setText("");
					
				}
		    	
		    });
		    
		    //삭제 버튼 클릭 이벤트 구현 
		    btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//테이블에서 선택된 행 번호 가져오기 
					int idx = table.getSelectedRow();
					//선택이 안된 경우 음수 
					if(idx < 0) {
						JOptionPane.showMessageDialog(
								null, "선택하고 삭제를 누르세요!!!");
					    return; 
					}
					//정말로 삭제할 것인지 확인 
					int r = JOptionPane.showConfirmDialog(
							null, "정말로 삭제하시겠습니까?", "진짜 삭제",
							JOptionPane.OK_CANCEL_OPTION);
					//OK눌렀을 때만 삭제 
					if(r == JOptionPane.OK_OPTION) {
								
					DefaultTableModel model =
							(DefaultTableModel)table.getModel();
					model.removeRow(idx);
					
					}
				
				}
		    	
		    });
			setBounds(100,100,500,300);
			//배치되는 컴퍼넌트 크기들을 가지고 프레임의 사이즈를 조정 
			pack(); 
			setTitle("항목 선택");
			setVisible(true);
			//닫기 버튼을 누를 때 종료해주는 기능 추가 
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
}
