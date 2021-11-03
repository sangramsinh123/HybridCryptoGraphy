package finalhybrid;

import static finalhybrid.RSA.buildKeyPair;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.lang.System.*;
import java.sql.*;

public class hybrid extends javax.swing.JFrame
{
	//18BIT0291
	//SANGRAMSINH SAWANT
	
    //creating the objects with 2 different classes
	
    AES AES = new AES();
    RSA RSA = new RSA();
    
    KeyPair keyPair;
    PublicKey pubKey;
    PrivateKey privateKey;
    
    String cipherMessage;
    
    byte [] encryptedKey;
    
    byte[] secret;
       
   
    //constructor invoked
    public hybrid()
    {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        eplainText = new javax.swing.JTextField();
        eencryptionKey = new javax.swing.JPasswordField();
        
        jScrollPane1 = new javax.swing.JScrollPane();
        
        eoutputWindow = new javax.swing.JTextArea();
        
        encryptButton = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        
        decryptButton = new javax.swing.JButton();
        
        jScrollPane2 = new javax.swing.JScrollPane();
        
        doutputWindow = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HYBRID CRYPTOGRAPHY 18BIT0291");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Elephant", 0, 18)); 
        setForeground(new java.awt.Color(0, 51, 204));
        setResizable(false);

        eplainText.setText("Enter the message ..");
        eplainText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eplainTextMouseClicked(evt);
            }
        });

        eoutputWindow.setColumns(20);
        eoutputWindow.setRows(5);
        jScrollPane1.setViewportView(eoutputWindow);

        encryptButton.setText("Encryption process");
        encryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
                encryptButtonActionPerformed(evt);
                
                /*add JDBC Here
                 */
                try {
                	Class.forName("com.mysql.jdbc.Driver");
                	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                	//PreparedStatement ps = conn.prepareStatement("insert into user2(message,ciphermessage,cipherkey,decryptedmessage) values(?,?,?,?)");
                	PreparedStatement ps = conn.prepareStatement("insert into user4(message,ciphermessage,cipherkey,decryptedmessage) values(?,?,?,?)");

                	ps.setString(1, eplainText.getText());
                	ps.setBytes(2, cipherMessage.getBytes());
                	
                	
                	ps.setString(3, encryptedKey.toString());
                	ps.setString(4,eplainText.getText());
                	
                	int x=ps.executeUpdate();
                	if(x>0){
                		System.out.println("added succesfully with "+x+" number of rows");
                	}
                	else {
                		System.out.println("check connection with web server");
                	}
                	
                	
                }catch(Exception e1) {
                	System.out.println(e1);
                }
            }
        });
        
        //TOP LABEL
        label.setBackground(new java.awt.Color(255, 255, 255));
        label.setFont(new java.awt.Font("Elephant", 0, 24)); 
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("HYBRID CRYPTOGRAPHY");

        decryptButton.setText("Decryption process");
        decryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                decryptButtonActionPerformed(evt);              
            }
        });

        doutputWindow.setColumns(20);
        doutputWindow.setRows(5);
        jScrollPane2.setViewportView(doutputWindow);

        
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
            
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                          .addComponent(encryptButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(eencryptionKey, javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                           .addComponent(decryptButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                               .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eplainText, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {decryptButton, eencryptionKey, encryptButton, eplainText, jScrollPane1, jScrollPane2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(eplainText, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eencryptionKey, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(encryptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decryptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        
        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {decryptButton, eencryptionKey, encryptButton, eplainText});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void encryptButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	
//    	if(eplainText.getText().equals(null) && eencryptionKey.getPassword().equals(null)) {
//    		eoutputWindow.setText("Please enter All the field!!");
//    		//System.out.println("nothing");
//    		eoutputWindow.setBackground(Color.black);
//    		eoutputWindow.setVisible(true);
//    		
//    	}
//    	else {
//    		try 
//            {
//                 long startTime=System.nanoTime();
//                //building the keys
//                keyPair = buildKeyPair();//contains public key and private key
//                pubKey = keyPair.getPublic();
//                privateKey = keyPair.getPrivate();
//                
//                //encrypted the message using the secret key
//                cipherMessage=AES.encrypt(eplainText.getText(),eencryptionKey.getText());          
//                try 
//                {
//                    //encrypting the secret key using the private key
//                    encryptedKey = RSA.encrypt(privateKey,eencryptionKey.getText());
//                    long endTime=System.nanoTime();
//                    long diff=endTime-startTime;
//                    eoutputWindow.setText("Cipher Message:"+AES.encrypt(eplainText.getText(),eencryptionKey.getText())+"\n"+
//                    						"Cipher Key:"+new String(encryptedKey)+"\n"+
//                    						"Time Required:"+diff+"\n"+
//                    						"Message Length:"+eplainText.getText().length());                    
//                } 
//                catch (Exception ex)
//                {
//                    Logger.getLogger(hybrid.class.getName()).log(Level.SEVERE, null, ex);
//                }              
//            } 
//            catch (NoSuchAlgorithmException ex)
//            {
//                Logger.getLogger(hybrid.class.getName()).log(Level.SEVERE, null, ex);
//            }
//    		
//    		
//    	}
    	//========================================================================
    	
        if(eplainText.getText() !=null && eencryptionKey.getText()!=null)//(eencryptionKey.getText()!=null)
        {
            try 
            {
                 long startTime=System.nanoTime();
                //building the keys
                keyPair = buildKeyPair();//contains public key and private key
                pubKey = keyPair.getPublic();
                privateKey = keyPair.getPrivate();
                
                //encrypted the message using the secret key
                //cipher message
                cipherMessage=AES.encrypt(eplainText.getText(),eencryptionKey.getText());          
                try 
                {
                    //encrypting the secret key using the private key
                	//cipher key
                    encryptedKey = RSA.encrypt(privateKey,eencryptionKey.getText());
                    long endTime=System.nanoTime();
                    long diff=endTime-startTime;
                    
                    eoutputWindow.setText("Cipher Message:"+AES.encrypt(eplainText.getText(),eencryptionKey.getText())+"\n"+
                    						"Cipher Key:"+new String(encryptedKey)+"\n"+
                    						"Time Required:"+diff+"\n"+
                    						"Message Length:"+eplainText.getText().length()); 
//                    eoutputWindow.setText(
//    						"Cipher Key:"+new String(encryptedKey));
    						 
                } 
                catch (Exception ex)
                {
                	//Find or create a logger for a named subsystem. 
                	//If a logger has already been created with the given name it is returned.
                	//Otherwise a new logger is created.
                    Logger.getLogger(hybrid.class.getName()).log(Level.SEVERE, null, ex);
                    //ex.printStackTrace();
                }              
            } 
            catch (NoSuchAlgorithmException ex)
            {
                Logger.getLogger(hybrid.class.getName()).log(Level.SEVERE, null, ex);
                //eoutputWindow.setText("Something went wrong in my Algorithm or check another exception");
            }          
        }
        else
        {
            eoutputWindow.setText("Please enter All the field");
        }
        
    }

    private void decryptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        try 
        {
            long startTime=System.nanoTime();
            secret = RSA.decrypt(pubKey,encryptedKey);//secret key decrypted
            String DecryptedMessage=AES.decrypt(cipherMessage,  new String(secret));
            long endTime=System.nanoTime();
            long diff=endTime-startTime;
            doutputWindow.setText("Decrypted Message:"+DecryptedMessage+"\n"+
            						"Decrypted Key:"+new String(secret)+"\n"+
            						"Time Required:"+diff);
        } 
        catch (Exception ex)
        {
            Logger.getLogger(hybrid.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

    private void eplainTextMouseClicked(java.awt.event.MouseEvent evt) {
        
        eplainText.setText("");
    }

   
    public static void main(String args[]) 
    {
        
        
        try {
        	//here we have used the enhanced for loop 
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            	//Nimbus uses instances of the Painter interface to paint components
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        
        /*
        catch(Exception ex){
            Logger.getLogger(hybrid.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        catch(classNotFoundException ex){
            Logger.getLogger(hybrid.class.getName()).log(Level.SEVERE, null, ex);
        }

        catch(IllegalAccessException ex){
            ex.printStackTrace();
        }


        */
        
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hybrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        
        java.awt.EventQueue.invokeLater(() -> {
            new hybrid().setVisible(true);
        });
    }

    //variables declaration and do not modify//
    private javax.swing.JButton decryptButton;
    private javax.swing.JTextArea doutputWindow;
    private javax.swing.JPasswordField eencryptionKey;
    private javax.swing.JButton encryptButton;
    private javax.swing.JTextArea eoutputWindow;
    private javax.swing.JTextField eplainText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    
}
