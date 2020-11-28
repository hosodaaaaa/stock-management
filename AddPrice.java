/**
 * AddPrice
 */
class AddPrice extends Goods {
  private int price;

  public AddPrice(String itemName, int itemNum, int price) {
    super(itemName, itemNum);
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}