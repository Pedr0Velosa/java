package br.com.fiap.ig;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.fiap.ig.controler.BotaoListener;
import br.com.fiap.ig.controler.TableListener;
import br.com.fiap.ig.dao.FilmeDao;
import br.com.fiap.ig.model.Filme;

public class Janela extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Input txtTitulo = new Input(0,0,0);//se passar parametros, muda a cor da borda
	private MeuTextArea txtSinopse = new MeuTextArea();
	private ButtonGroup agruparButton = new ButtonGroup();	
	private JCheckBox assistido = new JCheckBox("Assistido");
	private String[] generoList = {"","Ação", "Aventura", "Romance", "Comédia", "Sci-fi"};		
	private JComboBox<String> list = new JComboBox<String>(generoList);
	private StarRater star = new StarRater();
	String[] colunas = {"Id", "Titulo", "Sinopse", "Genero", "Plataforma", "Assistido?", "Avaliação"};
	private DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	JTable tabela = new JTable(tableModel);
	
	public Janela() {
		setSize(660, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Fiap Movies");
	}
	
	public void init() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		JTabbedPane abas = new JTabbedPane();

		JPanel cadastro = new JPanel();
				
		BorderLayout bLayout = new BorderLayout();
		bLayout.setHgap(30);
		cadastro.setLayout(bLayout);
		
		
		abas.addTab("Cadastro", cadastro);
		abas.addTab("Tabela", new JScrollPane(tabela));
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
			MeuLabel titulo = new MeuLabel("Título");
			MeuLabel sinopse = new MeuLabel("Sinopse");

			JPanel tituloContainer = new JPanel();
				tituloContainer.setLayout(new FlowLayout(0, 0, 5));//alinhamento, Hgap, Vgap
				tituloContainer.add(titulo);
				tituloContainer.add(txtTitulo);
			JPanel sinopseContainer = new JPanel();
				sinopseContainer.setLayout(new FlowLayout(0, 0, 5));
				sinopseContainer.add(sinopse);
				sinopseContainer.add(txtSinopse);
			
			
			
			titulo.setLayout(new BorderLayout());		
			MeuLabel genero = new MeuLabel("Gênero");
			
			JPanel generoContainer = new JPanel();
				generoContainer.setLayout(new FlowLayout(0, 5, 5));
				generoContainer.add(genero);
				generoContainer.add(list);
				
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
		direita.setLayout(new BoxLayout(direita, BoxLayout.PAGE_AXIS));
			MeuLabel ondeAssistir = new MeuLabel("Onde assistir");
			MeuLabel avaliacao = new MeuLabel("Avaliação");
			
			JPanel botoesGroup = new JPanel();
			botoesGroup.setLayout(new BoxLayout(botoesGroup , BoxLayout.PAGE_AXIS));
				JRadioButton netflix = new JRadioButton("Netflix");
					netflix.setActionCommand("Netflix");
					netflix.setSelected(true);
				JRadioButton primeVideo = new JRadioButton("Prime Video");
					primeVideo.setActionCommand("Prime Video");
				JRadioButton pirateBay = new JRadioButton("Pirate Bay");
					pirateBay.setActionCommand("Pirate Bay");
				
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
		direita.add(star);

		
		JButton button = new JButton(new ImageIcon(((new ImageIcon("./img/filme.jpg")).getImage()).getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH)));
		
		
		cadastro.add(button, BorderLayout.LINE_START);
		cadastro.add(center, BorderLayout.CENTER);
		cadastro.add(direita, BorderLayout.LINE_END);
		
		
		carregarDados();
		
		TableListener tableListener = new TableListener();
		tabela.addMouseListener(tableListener);
		
		tabela.setDefaultEditor(Object.class, null);
		
		
		BotaoListener listener = new BotaoListener(this);
		salvar.addActionListener(listener);
		
		this.add(abas);
		setVisible(true);
	}
	
	public void carregarDados() {
		tableModel.setRowCount(0);		List<Filme> lista = new FilmeDao().listarTodos();
		lista.forEach(filme -> tableModel.addRow(filme.getData()));	
	}
	
	public int getAvalicao() {
		return star.getSelection();
	}
	
	public boolean getAssistido() {
		return assistido.isSelected();
	}

	public Input getTxtTitulo() {
		return txtTitulo;
	}

	public MeuTextArea getTxtSinopse() {
		return txtSinopse;
	}
	
	public String getGenero() {
		return list.getSelectedItem().toString();
	}
	
	public String getPlataforma() {
		return agruparButton.getSelection().getActionCommand();
	}

	public void setTxtTitulo(String txtTitulo) {
		this.txtTitulo.setText(txtTitulo);
	}

	public void setTxtSinopse(String txtSinopse) {
		this.txtSinopse.setText(txtSinopse);
	}
	
	
}
