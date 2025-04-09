/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Event.EventClick;
import Model.DayLookup;
import Model.Dictionary;
import Model.HandleXMLFile;
import Model.Model_Button;
import Model.DataSearch;
import Swing.PanelSearch;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author RAVEN
 */
public class LookupForm extends javax.swing.JPanel {

    private int keyLanguage = 1; // 1 - Anh Viet ; 0 - Viet Anh 
    private int keyFavourite = 0; // 1 - true ; 0 - false
    private String searchText;
    private String meaning;
    Dictionary dictionary = new Dictionary();
    ArrayList<String> dataStory;
    private JPopupMenu menu;
    private PanelSearch search;

    /**
     * Creates new form Form_1
     *
     * @param d
     */
    public LookupForm(Dictionary d) {
        initComponents();
        dictionary = d;
        SearchButton.setData(new Model_Button(new ImageIcon(getClass().getResource("/com/raven/icon/search.png")), "Tìm kiếm"));
        SwitchLanguage.setData(new Model_Button(new ImageIcon(getClass().getResource("/com/raven/icon/4.png")), "Anh - Việt"));
        favoriteWord.setVisible(false);
        initSearch();
    }

    public void initSearch() {

        dataStory = new ArrayList<>();

        menu = new JPopupMenu();
        search = new PanelSearch();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);

        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu.setVisible(false);
                SearchText.setText(data.getText());

                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search.remove(com);
                removeHistory(data.getText());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
                if (search.getItemSize() == 0) {
                    menu.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
    }

    private List<DataSearch> search(String search) {
        int limitData = 7;
        List<DataSearch> list = new ArrayList<>();
        Set<String> data;
        if (keyLanguage == 1) {
            data = dictionary.getAnh_Viet().getRecords().keySet();
        } else {
            data = dictionary.getViet_Anh().getRecords().keySet();
        }
        for (String d : data) {
            // tim gioi han 
            if (d.contains(search) && (d.length() - search.length()) < 4) {
                boolean story = isStory(d);
                if (story) {
                    list.add(0, new DataSearch(d, story));
                    //  add or insert to first record
                } else {
                    list.add(new DataSearch(d, story));
                    //  add to last record
                }
                if (list.size() == limitData) {
                    break;
                }
            }
        }

        // neu size < lim -> tim trong ds tu moi
        if (list.size()
                < limitData) {
            if (keyLanguage == 1) {
                data = Dictionary.listNewWordAnh_Viet.getRecords().keySet();
            } else {
                data = Dictionary.listNewWordViet_Anh.getRecords().keySet();
            }
            for (String d : data) {
                if (d.contains(search)) {
                    boolean story = isStory(d);
                    if (story) {
                        list.add(0, new DataSearch(d, story));
                        //  add or insert to first record
                    } else {
                        list.add(new DataSearch(d, story));
                        //  add to last record
                    }
                    if (list.size() == limitData) {
                        break;
                    }
                }
            }

        }
        // tim khong gioi han

        if (list.size() < limitData) {
            if (keyLanguage == 1) {
                data = dictionary.getAnh_Viet().getRecords().keySet();
            } else {
                data = dictionary.getViet_Anh().getRecords().keySet();
            }
            for (String d : data) {
                if (d.contains(search)) {
                    boolean story = isStory(d);
                    if (story) {
                        list.add(0, new DataSearch(d, story));
                        //  add or insert to first record
                    } else {
                        list.add(new DataSearch(d, story));
                        //  add to last record
                    }
                    if (list.size() == limitData) {
                        break;
                    }
                }
            }

        }
        return list;
    }

    private void removeHistory(String text) {
        for (int i = 0; i < dataStory.size(); i++) {
            String d = dataStory.get(i);
            if (d.toLowerCase().equals(text.toLowerCase())) {
                dataStory.set(i, "");
            }
        }
    }

    private boolean isStory(String text) {
        for (String d : dataStory) {
            if (d.toLowerCase().equals(text.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SearchButton = new Components.Button();
        SwitchLanguage = new Components.Button();
        SearchText = new Components.TextBoxSearch();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        meaningSearch = new javax.swing.JTextArea();
        titleSearch = new javax.swing.JLabel();
        favoriteWord = new javax.swing.JPanel();
        iconStar = new javax.swing.JLabel();
        titleSearch1 = new javax.swing.JLabel();

        SearchButton.setColor1(new java.awt.Color(28, 181, 224));
        SearchButton.setColor2(new java.awt.Color(0, 0, 120));
        SearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchButtonMouseEntered(evt);
            }
        });
        SearchButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchButtonKeyPressed(evt);
            }
        });

        SwitchLanguage.setColor1(new java.awt.Color(28, 181, 224));
        SwitchLanguage.setColor2(new java.awt.Color(0, 0, 120));
        SwitchLanguage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SwitchLanguageMouseClicked(evt);
            }
        });

        SearchText.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        SearchText.setPreferredSize(new java.awt.Dimension(684, 47));
        SearchText.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search.png"))); // NOI18N
        SearchText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchTextMouseClicked(evt);
            }
        });
        SearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextActionPerformed(evt);
            }
        });
        SearchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SwitchLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SwitchLanguage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SearchText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        meaningSearch.setEditable(false);
        meaningSearch.setColumns(20);
        meaningSearch.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        meaningSearch.setRows(5);
        jScrollPane1.setViewportView(meaningSearch);

        titleSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titleSearch.setForeground(new java.awt.Color(16, 103, 158));
        titleSearch.setText("Từ khóa `  ` được dịch như sau:");

        favoriteWord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        favoriteWord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favoriteWordMouseClicked(evt);
            }
        });

        iconStar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/star.png"))); // NOI18N

        titleSearch1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titleSearch1.setForeground(new java.awt.Color(16, 103, 158));
        titleSearch1.setText("Yêu thích");

        javax.swing.GroupLayout favoriteWordLayout = new javax.swing.GroupLayout(favoriteWord);
        favoriteWord.setLayout(favoriteWordLayout);
        favoriteWordLayout.setHorizontalGroup(
            favoriteWordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(favoriteWordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(favoriteWordLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(titleSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(iconStar)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        favoriteWordLayout.setVerticalGroup(
            favoriteWordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
            .addGroup(favoriteWordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(favoriteWordLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addGroup(favoriteWordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(titleSearch1)
                        .addComponent(iconStar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(favoriteWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleSearch)
                    .addComponent(favoriteWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_SearchButtonMouseEntered

    private void SwitchLanguageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SwitchLanguageMouseClicked
        // TODO add your handling code here:
        if (keyLanguage == 1) {
            keyLanguage = 0;
            SwitchLanguage.setData(new Model_Button(new ImageIcon(getClass().getResource("/com/raven/icon/4.png")), "Việt - Anh"));
            //SearchText.setHintText("Nhập từ tiếng Việt");
            //addSuggestionFromDictionary();

        } else {
            keyLanguage = 1;
            SwitchLanguage.setData(new Model_Button(new ImageIcon(getClass().getResource("/com/raven/icon/4.png")), "Anh - Việt"));
            //SearchText.setHintText("Nhập từ tiếng Anh");
            ////addSuggestionFromDictionary();

        }

    }//GEN-LAST:event_SwitchLanguageMouseClicked

    private int checkFavoriteWord(int keyL, String word) {
        if (keyL == 1) {
            if (Dictionary.listFavoriteWordEnglish.checkWord(word)) {
                return 1;
            }
            return 0;
        } else {
            if (Dictionary.listFavoriteWordVietnamese.checkWord(word)) {
                return 1;
            }
            return 0;
        }
    }

    private void addRecordFavorite(int keyL, String word, String meaning) {
        HandleXMLFile handleXMLFile = new HandleXMLFile();
        if (keyL == 1) {
            Dictionary.listFavoriteWordEnglish.addRecord(word, meaning);
            handleXMLFile.writeXMLFile("favoriteEnglish", "Data/favoriteEnglish.xml", Dictionary.listFavoriteWordEnglish, "word", "meaning");

        } else {
            Dictionary.listFavoriteWordVietnamese.addRecord(word, meaning);
            handleXMLFile.writeXMLFile("favoriteVietnamese", "Data/favoriteVietnamese.xml", Dictionary.listFavoriteWordVietnamese, "word", "meaning");

        }
    }

    private void removeRecordFavorite(int keyL, String word) {
        HandleXMLFile handleXMLFile = new HandleXMLFile();
        if (keyL == 1) {
            Dictionary.listFavoriteWordEnglish.removeRecord(word);
            handleXMLFile.writeXMLFile("favoriteEnglish", "Data/favoriteEnglish.xml", Dictionary.listFavoriteWordEnglish, "word", "meaning");

        } else {
            Dictionary.listFavoriteWordVietnamese.removeRecord(word);
            handleXMLFile.writeXMLFile("favoriteVietnamese", "Data/favoriteVietnamese.xml", Dictionary.listFavoriteWordVietnamese, "word", "meaning");

        }
    }

    public String handlingString(String str) {

        //str = str.toLowerCase();
        str = str.trim();
        return str;
    }

    String searchDictionary(String word) {
        if (keyLanguage == 1) {
            return (String) dictionary.getAnh_Viet().getMeaning(word);
        }
        return (String) dictionary.getViet_Anh().getMeaning(word);
    }

    String searchListNewWord(String word) {
        if (keyLanguage == 1) {
            return (String) Dictionary.listNewWordAnh_Viet.getMeaning(word);
        }
        return (String) Dictionary.listNewWordViet_Anh.getMeaning(word);
    }

    void addToListLookup() {

        LocalDate currentDate = LocalDate.now();
        HandleXMLFile handleXMLFile = new HandleXMLFile();

        // duyet daylookup
        for (int i = 0; i < Dictionary.listSearch.size(); i++) {
            if (currentDate.equals(Dictionary.listSearch.get(i).getDate())) {

                if (Dictionary.listSearch.get(i).getWords().containsKey(searchText)) {
                    int value = (int) Dictionary.listSearch.get(i).getWords().get(searchText) + 1;
                    Dictionary.listSearch.get(i).getWords().put(searchText, value);
                } else {
                    Dictionary.listSearch.get(i).getWords().put(searchText, 1);
                }
                handleXMLFile.writeFileLookup("lookup_history", "Data/listSearch.xml", Dictionary.listSearch);
                return;
            }
        }
        DayLookup d = new DayLookup();
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put(searchText, 1);
        d.setDate(currentDate);
        d.setWords(hm);
        Dictionary.listSearch.add(d);
        handleXMLFile.writeFileLookup("lookup_history", "Data/listSearch.xml", Dictionary.listSearch);
    }

    private void SearchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMouseClicked
        // TODO add your handling code here:
        searchText = SearchText.getText();
        searchText = handlingString(searchText);

        meaning = searchListNewWord(searchText);
        System.out.println(meaning);
        if (meaning == null) {
            meaning = searchDictionary(searchText);

            if (meaning == null) {
                meaningSearch.setText("Không tìm thấy !!!!!");
                favoriteWord.setVisible(false);
            } else {
                meaningSearch.setText(meaning);
                favoriteWord.setVisible(true);
                keyFavourite = checkFavoriteWord(keyLanguage, searchText);
                setColorStar(keyFavourite);
                addToListLookup();
                dataStory.add(searchText);
            }
        } else {
            meaningSearch.setText(meaning);
            favoriteWord.setVisible(true);
            keyFavourite = checkFavoriteWord(keyLanguage, searchText);
            setColorStar(keyFavourite);
            addToListLookup();
            dataStory.add(searchText);
        }

        String str = "Từ khóa ``" + searchText + "`` được dịch như sau: ";
        titleSearch.setText(str);

    }//GEN-LAST:event_SearchButtonMouseClicked

    private void setColorStar(int keyF) {
        if (keyF == 1) {
            iconStar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/star_yellow.png")));

        } else {
            iconStar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/star.png")));

        }
    }

    private void favoriteWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favoriteWordMouseClicked
        // TODO add your handling code here:
        if (keyFavourite == 0) {
            addRecordFavorite(keyLanguage, searchText, meaning);
            keyFavourite = 1;
            setColorStar(keyFavourite);
            JOptionPane.showMessageDialog(this, "Thêm vào danh sách yêu thích thành công!");

        } else {
            removeRecordFavorite(keyLanguage, searchText);
            keyFavourite = 0;
            setColorStar(keyFavourite);
            JOptionPane.showMessageDialog(this, "Đã xóa khỏi danh sách yêu thích !");
        }

    }//GEN-LAST:event_favoriteWordMouseClicked

    private void SearchButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchButtonKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_SearchButtonKeyPressed

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextActionPerformed

    private void SearchTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchTextMouseClicked
        // TODO add your handling code here:
        if (search.getItemSize() > 0) {
            menu.show(SearchText, 0, SearchText.getHeight());
        }
    }//GEN-LAST:event_SearchTextMouseClicked

    private void SearchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = SearchText.getText().trim().toLowerCase();
            search.setData(search(text));
            if (search.getItemSize() > 0) {
                //  * 2 top and bot border
                menu.show(SearchText, 0, SearchText.getHeight());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
            } else {
                menu.setVisible(false);
            }
        }

    }//GEN-LAST:event_SearchTextKeyReleased

    private void SearchTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            menu.setVisible(false);

            searchText = SearchText.getText();
            searchText = handlingString(searchText);

            meaning = searchListNewWord(searchText);
            System.out.println(meaning);
            if (meaning == null) {
                meaning = searchDictionary(searchText);

                if (meaning == null) {
                    meaningSearch.setText("Không tìm thấy !!!!!");
                    favoriteWord.setVisible(false);
                } else {
                    meaningSearch.setText(meaning);
                    favoriteWord.setVisible(true);
                    keyFavourite = checkFavoriteWord(keyLanguage, searchText);
                    setColorStar(keyFavourite);
                    addToListLookup();
                    dataStory.add(searchText);
                }
            } else {
                meaningSearch.setText(meaning);
                favoriteWord.setVisible(true);
                keyFavourite = checkFavoriteWord(keyLanguage, searchText);
                setColorStar(keyFavourite);
                addToListLookup();
                dataStory.add(searchText);
            }

            String str = "Từ khóa ``" + searchText + "`` được dịch như sau: ";
            titleSearch.setText(str);

        }
    }//GEN-LAST:event_SearchTextKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.Button SearchButton;
    private Components.TextBoxSearch SearchText;
    private Components.Button SwitchLanguage;
    private javax.swing.JPanel favoriteWord;
    private javax.swing.JLabel iconStar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea meaningSearch;
    private javax.swing.JLabel titleSearch;
    private javax.swing.JLabel titleSearch1;
    // End of variables declaration//GEN-END:variables
}
