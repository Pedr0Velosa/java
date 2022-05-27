package br.com.fiap.ig;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class Janela {

	public static void main(String[] args) {


		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
				
		JFrame janela = new JFrame("Fiap Movies");
		JTabbedPane abas = new JTabbedPane();

		JPanel cadastro = new JPanel();
		JPanel lista = new JPanel();//não feita ainda
		BorderLayout bLayout = new BorderLayout();
		bLayout.setHgap(30);
		cadastro.setLayout(bLayout);
		
		abas.addTab("Cadastro", cadastro);
		abas.addTab("Lista", lista);
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
			MeuLabel titulo = new MeuLabel("Título");
			Input input_1 = new Input(0,0,0);//se passar parametros, muda a cor da borda
			MeuLabel sinopse = new MeuLabel("Sinopse");
			Input input_2 = new Input(255,255,255);

			JPanel tituloContainer = new JPanel();
				tituloContainer.setLayout(new FlowLayout(0, 0, 5));//alinhamento, Hgap, Vgap
				tituloContainer.add(titulo);
				tituloContainer.add(input_1);
			JPanel sinopseContainer = new JPanel();
				sinopseContainer.setLayout(new FlowLayout(0, 0, 5));
				sinopseContainer.add(sinopse);
				sinopseContainer.add(input_2);
			
			
			
			//titulo.setLayout(new BorderLayout());		
			MeuLabel genero = new MeuLabel("Gênero");
			String[] generoList = {"","Ação", "Aventura", "Romance", "Comédia", "Sci-fi"};		
			
			
			JPanel generoContainer = new JPanel();
				generoContainer.setLayout(new FlowLayout(0, 0, 5));
				generoContainer.add(genero);
				generoContainer.add(new JComboBox<String>(generoList));
				
			JPanel botoes = new JPanel();
				botoes.setLayout(new BoxLayout(botoes, BoxLayout.X_AXIS));
				JButton salvar = new JButton("Salvar");
				JButton cancelar = new JButton("Cancelar");
				botoes.add(salvar);
				botoes.add(cancelar);
			
		center.add(tituloContainer);
		center.add(sinopseContainer);
		center.add(generoContainer);
		center.add(botoes);
			
			
		JPanel direita = new JPanel();
		direita.setLayout(new BoxLayout(direita, 1));
			MeuLabel ondeAssistir = new MeuLabel("Onde assistir");
			MeuLabel avaliacao = new MeuLabel("Avaliação");
			MeuLabel ESTRELASMUDAR = new MeuLabel("ESTRELASMUDAR");
			
			JPanel botoesGroup = new JPanel();
			botoesGroup.setLayout(new BoxLayout(botoesGroup , 1));
				JRadioButton netflix = new JRadioButton("Netflix");
				JRadioButton primeVideo = new JRadioButton("Prime Video");
				JRadioButton pirateBay = new JRadioButton("Pirate Bay");
				JCheckBox assistido = new JCheckBox("Assistido");
							
				ButtonGroup agruparButton = new ButtonGroup();	
				agruparButton.add(netflix);
				agruparButton.add(primeVideo);
				agruparButton.add(pirateBay);
				
				botoesGroup.add(netflix);
				botoesGroup.add(primeVideo);
				botoesGroup.add(pirateBay);
				botoesGroup.add(assistido);
			
		
		direita.add(ondeAssistir);
		direita.add(botoesGroup);
		direita.add(avaliacao);
		direita.add(ESTRELASMUDAR);

		
		JButton button = new JButton(new ImageIcon(((new ImageIcon("C:\\\\Users\\\\T-Gamer\\\\Pictures\\\\Camera Roll\\\\wandaVision.jpg")).getImage()).getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		
		
		cadastro.add(button, BorderLayout.LINE_START);
		cadastro.add(center, BorderLayout.CENTER);
		cadastro.add(direita, BorderLayout.LINE_END);
		
		janela.add(abas);
		janela.setSize(660, 400);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setVisible(true);
	}
	
	
}
