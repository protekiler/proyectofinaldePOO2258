package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Vista extends JFrame{
    private GridLayout layout;
    //cosas panel1
    private JPanel panel1;
    private JLabel LBlID;
    private JLabel LBLNombreDulce;
    private JLabel LBlTipoDeDulce;
    private JLabel LBlCantidadGramos;
    private JLabel LBlprecioDulce;
    private JLabel LBlfotoDulce;
    private JTextField txtID;
    private JTextField txtNombreDulce;
    private JTextField txtTipoDulce;
    private JTextField txtCantidadGramos;
    private JTextField txtprecioDulce;
    private JTextField txtfotoDulce;
    private JButton BotonAgregar;
    private JLabel imagenDulce;

    //cosas del panel 2

    private JPanel panel2;
    private JButton botoncarga;
    private JScrollPane scroll;
    private JTable tblTabla;

    //cosas panel3
    private JPanel panel3;


    //cosas panel4
    private JPanel panel4;
    private JLabel EliminarFila;
    private JLabel EliminarDato;
    private JButton BotonEliminarFila;
    private JButton BotonEliminarCasilla;
    private JTextField Cambio;




    public Vista(String title) throws HeadlessException {
        super(title);
        this.setSize(1250,600);
        layout=new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        panel1=new JPanel();
        this.getContentPane().add(panel1,0);
        panel1.setBackground(new Color(223, 120, 229));
        LBlID =new JLabel("id");
        txtID=new JTextField(4);
        LBLNombreDulce =new JLabel("NOMBRE");
        txtNombreDulce=new JTextField(15);
        LBlTipoDeDulce =new JLabel("Tipo");
        txtTipoDulce=new JTextField(10);
        LBlCantidadGramos =new JLabel("cantidad (gm)");
        txtCantidadGramos=new JTextField(5);
        LBlprecioDulce =new JLabel("precio");
        txtprecioDulce=new JTextField(5);
        LBlfotoDulce =new JLabel("fotodulce");
        txtfotoDulce=new JTextField(20);
        BotonAgregar=new JButton("Agregar info");

        panel1.add(LBlID);
        panel1.add(txtID);
        panel1.add(LBLNombreDulce);
        panel1.add(txtNombreDulce);
        panel1.add(LBlTipoDeDulce);
        panel1.add(txtTipoDulce);
        panel1.add(LBlCantidadGramos);
        panel1.add(txtCantidadGramos);
        panel1.add(LBlprecioDulce);
        panel1.add(txtprecioDulce);
        panel1.add(LBlfotoDulce);
        panel1.add(txtfotoDulce);
        panel1.add(BotonAgregar);


//aqui empiezan datos panel2
        panel2=new JPanel();
        botoncarga=new JButton("CARGA");
        this.getContentPane().add(panel2,1);
        panel2.setBackground(new Color(254, 120, 247));
        tblTabla=new JTable();
        scroll=new JScrollPane(tblTabla);


        panel2.add(scroll);
        panel2.add(botoncarga);


//aqui empiezan datos panel3
        panel3=new JPanel();
        this.getContentPane().add(panel3,2);
        panel3.setBackground(new Color(220, 129, 142));

        imagenDulce=new JLabel("...");
        panel3.add(imagenDulce);


//aqui empiezan datos panel3
        panel4=new JPanel();
        this.getContentPane().add(panel4,3);
        panel4.setBackground(new Color(217, 93, 232));
        EliminarFila=new JLabel("Para eliminar una fila seleccione la fila correspondiente y presione el siguiente boton");
        BotonEliminarFila=new JButton("Eliminar Fila");

        EliminarDato=new JLabel("Escriba el nuevo dato,selecciones la casilla y oprima el boton",SwingConstants.RIGHT);
        Cambio=new JTextField(20);
        BotonEliminarCasilla=new JButton("Eliminar Dato");
        panel4.add(EliminarFila);
        panel4.add(BotonEliminarFila);
        panel4.add(EliminarDato);
        panel4.add(Cambio);
        panel4.add(BotonEliminarCasilla);


        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public JTextField getCambio() {
        return Cambio;
    }

    public void setCambio(JTextField cambio) {
        Cambio = cambio;
    }

    public JButton getBotonEliminarFila() {
        return BotonEliminarFila;
    }

    public void setBotonEliminarFila(JButton botonEliminarFila) {
        BotonEliminarFila = botonEliminarFila;
    }

    public JButton getBotonEliminarCasilla() {
        return BotonEliminarCasilla;
    }

    public void setBotonEliminarCasilla(JButton botonEliminarCasilla) {
        BotonEliminarCasilla = botonEliminarCasilla;
    }

    public JButton getBotoncarga() {
        return botoncarga;
    }

    public void setBotoncarga(JButton botoncarga) {
        this.botoncarga = botoncarga;
    }

    public JLabel getImagenDulce() {
        return imagenDulce;
    }

    public void setImagenDulce(JLabel imagenDulce) {
        this.imagenDulce = imagenDulce;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JLabel getLBlID() {
        return LBlID;
    }

    public void setLBlID(JLabel LBlID) {
        this.LBlID = LBlID;
    }

    public JLabel getLBLNombreDulce() {
        return LBLNombreDulce;
    }

    public void setLBLNombreDulce(JLabel LBLNombreDulce) {
        this.LBLNombreDulce = LBLNombreDulce;
    }

    public JLabel getLBlTipoDeDulce() {
        return LBlTipoDeDulce;
    }

    public void setLBlTipoDeDulce(JLabel LBlTipoDeDulce) {
        this.LBlTipoDeDulce = LBlTipoDeDulce;
    }

    public JLabel getLBlCantidadGramos() {
        return LBlCantidadGramos;
    }

    public void setLBlCantidadGramos(JLabel LBlCantidadGramos) {
        this.LBlCantidadGramos = LBlCantidadGramos;
    }

    public JLabel getLBlprecioDulce() {
        return LBlprecioDulce;
    }

    public void setLBlprecioDulce(JLabel LBlprecioDulce) {
        this.LBlprecioDulce = LBlprecioDulce;
    }

    public JLabel getLBlfotoDulce() {
        return LBlfotoDulce;
    }

    public void setLBlfotoDulce(JLabel LBlfotoDulce) {
        this.LBlfotoDulce = LBlfotoDulce;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtNombreDulce() {
        return txtNombreDulce;
    }

    public void setTxtNombreDulce(JTextField txtNombreDulce) {
        this.txtNombreDulce = txtNombreDulce;
    }

    public JTextField getTxtTipoDulce() {
        return txtTipoDulce;
    }

    public void setTxtTipoDulce(JTextField txtTipoDulce) {
        this.txtTipoDulce = txtTipoDulce;
    }

    public JTextField getTxtCantidadGramos() {
        return txtCantidadGramos;
    }

    public void setTxtCantidadGramos(JTextField txtCantidadGramos) {
        this.txtCantidadGramos = txtCantidadGramos;
    }

    public JTextField getTxtprecioDulce() {
        return txtprecioDulce;
    }

    public void setTxtprecioDulce(JTextField txtprecioDulce) {
        this.txtprecioDulce = txtprecioDulce;
    }

    public JTextField getTxtfotoDulce() {
        return txtfotoDulce;
    }

    public void setTxtfotoDulce(JTextField txtfotoDulce) {
        this.txtfotoDulce = txtfotoDulce;
    }

    public JButton getBotonAgregar() {
        return BotonAgregar;
    }

    public void setBotonAgregar(JButton botonAgregar) {
        BotonAgregar = botonAgregar;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }


    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JTable getTblTabla() {
        return tblTabla;
    }

    public void setTblTabla(JTable tblTabla) {
        this.tblTabla = tblTabla;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }
    public void limpiar(){
        txtID.setText("");
        txtNombreDulce.setText("");
        txtTipoDulce.setText("");
        txtCantidadGramos.setText("");
        txtprecioDulce.setText("");
        txtfotoDulce.setText("");
    }
}
