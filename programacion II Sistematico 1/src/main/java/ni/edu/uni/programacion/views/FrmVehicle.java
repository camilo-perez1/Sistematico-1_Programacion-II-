/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import ni.edu.uni.programacion.controllers.PnlVehicleController;
import ni.edu.uni.programacion.views.panels.PnlVehicle;
import ni.edu.uni.programacion.views.panels.PnlVehiclesList;

/**
 *
 * @author Sistemas-05
 */
public class FrmVehicle extends javax.swing.JFrame {
    private PnlVehicle pnlVehicle;
    private PnlVehicleController pnlVehicleController;
    private PnlVehiclesList vehiclesList;
    private JsonVehicleDaoImpl vjdao;
  
    
      
    /**
     * Creates new form FrmVehicle
     */
    
    public FrmVehicle() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        pnlContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(120);
        jSplitPane1.setOneTouchExpandable(true);

        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew);

        btnView.setText("Ver");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel1.add(btnView);

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        pnlTop.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(pnlTop, java.awt.BorderLayout.PAGE_START);

        pnlContent.setLayout(new java.awt.BorderLayout());
        jPanel2.add(pnlContent, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(675, 555));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        if(pnlVehicle == null){
            pnlVehicle = new PnlVehicle();
            try {
                pnlVehicleController = new  PnlVehicleController(pnlVehicle);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"This file does not exists", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        addComponent(pnlVehicle);
    }//GEN-LAST:event_btnNewActionPerformed

//ESTE AUN NO EST?? TERMINADO LCSM
    
    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        if (vehiclesList == null) {
                    vehiclesList = new PnlVehiclesList();
                    //pnlVehicleController = new PnlVehicleController(vehiclesList);
        }
        
        try {
            vjdao = new JsonVehicleDaoImpl();
          
            //vjdao.create(v);
            
            List<Vehicle> vehicles = (List<Vehicle>) vjdao.getAll();
            
            String matris[][] = new String[vehicles.size()][5];
            for(int i = 0; i < vehicles.size(); i++){
                String a??o = String.valueOf(vehicles.get(i).getYear());
                matris[i][0] = a??o;
                matris[i][1] = vehicles.get(i).getMake();
                matris[i][2] = vehicles.get(i).getModel();
                matris[i][3] = vehicles.get(i).getStyle();
                matris[i][4] = vehicles.get(i).getVin();
                
            }
            vehiclesList.getjTable2().setModel(new javax.swing.table.DefaultTableModel(
            matris,
            
            new String [] {
                "Year", "Make", "Model", "Style", "VIN"
            }
        ));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        addComponent(vehiclesList);   
        
    }//GEN-LAST:event_btnViewActionPerformed

    
     private void addComponent(JComponent component) {
        pnlContent.removeAll();
        pnlContent.add(component, BorderLayout.CENTER);
        
        validate();
        repaint();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVehicle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlTop;
    // End of variables declaration//GEN-END:variables
}
