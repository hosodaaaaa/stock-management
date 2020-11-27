class Goods {
  //  アイテムを格納する変数
  private String itemName;
  private int itemNum;

  // デフォルトコンストラクタ
  public Goods() {
  }

  public Goods(String itemName, int itemNum) {
    this.itemName = itemName;
    this.itemNum = itemNum;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public int getItemNum() {
    return itemNum;
  }

  public void setItemNum(int itemNum) {
    this.itemNum = itemNum;
  }
}
