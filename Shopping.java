import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Shopping {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Map<Integer, String> stockList = new HashMap<Integer, String>();

    while (true) {
      // メニューの表示
      String[] menus = { "1.商品生産", "2.在庫一覧", "3.商品購入", "9.終了" };
      for (String menu : menus) {
        System.out.println(menu);
      }

      // メニュー項目番号を受け取る箱を用意する
      System.out.print("メニューを選択してください: ");
      int select = scan.nextInt();
      scan.nextLine();

      // 各メニューの分岐処理
      if (select == 1) {
        System.out.println("「商品生産」が選択されました");
        System.out.println();

        int i = 0;
        while (true) {
          i++;
          System.out.println(i + "つ目の商品を生産します");

          // Userに在庫情報を追加させる
          System.out.print("商品名を入力してください: ");
          String itemName = scan.nextLine();
          System.out.print("在庫数を入力してください: ");
          int itemNum = scan.nextInt();
          scan.nextLine();

          // 入力した値をコンストラクタに渡す
          Goods good = new Goods(itemName, itemNum);
          stockList.put(itemNum, itemName);
          System.out.println();

          // 2回目以降の入力処理を
          // させるか否かの判定を取得する
          System.out.print((i + 1) + "つ目の商品を生産しますか? (y/n): ");
          String answer = scan.nextLine();
          if (answer.equals("n")) {
            break;
          }
        }
      } else if (select == 2) {
        System.out.println("「在庫一覧」が選択されました");
        System.out.println();
        System.out.println("商品No. " + " 在庫 " + " 商品名 ");
        System.out.println("--------------------------------");
        int no = 0;
        for (Map.Entry<Integer, String> stockLists : stockList.entrySet()) {
          no++;
          System.out.println(no + "         " + stockLists.getKey() + "     " + stockLists.getValue());
        }
        System.out.println("--------------------------------");

      } else if (select == 3) {
        while (true) {
          System.out.println("「商品購入」が選択されました");
          System.out.println();
          System.out.println("商品No. " + " 在庫 " + " 商品名 ");
          System.out.println("--------------------------------");
          int no = 0;
          for (Map.Entry<Integer, String> stockLists : stockList.entrySet()) {
            no++;
            System.out.println(no + "         " + stockLists.getKey() + "     " + stockLists.getValue());
          }
          System.out.println("--------------------------------");

          // 改行
          System.out.println();

          // 購入情報を取得する
          System.out.print("商品No.を入力してください: ");
          int selectNo = scan.nextInt();
          scan.nextLine();
          System.out.print("個数を入力してください: ");
          int selectNum = scan.nextInt();
          scan.nextLine();

          // MapをListに変換
          List<Integer> keys = new ArrayList<Integer>(stockList.keySet());
          List<String> value = new ArrayList<String>(stockList.values());

          for (int i = 0; i <= keys.size(); i++) {
            if (selectNo == i) {
              stockList.remove(keys.get(i - 1));

              stockList.put(keys.get(i - 1) - selectNum, value.get(i - 1));
              if (keys.get(i - 1) - selectNum < 0) {
                System.out.println("在庫がありません");
                break;
              }
            }
          }
        }

      } else if (select == 9) {
        System.out.println("またご来店ください");
        break;
      }
    }
  }
}
