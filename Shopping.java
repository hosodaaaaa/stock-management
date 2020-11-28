import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shopping {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    List<AddPrice> stockList = new ArrayList<AddPrice>();

    while (true) {
      // メニュー表示
      String[] menus = { "1.商品を追加する", "2.商品一覧を確認する", "3.商品を購入する", "9.終了" };
      for (String menu : menus) {
        System.out.println(menu);
      }
      System.out.print("メニューを選択してください: ");
      int selectMenu = scan.nextInt();
      scan.nextLine();

      // 各メニューの操作
      if (selectMenu == 1) {
        int nth = 0;
        while (true) {
          // nth回目の番号を割り振る
          nth++;
          System.out.println(nth + "つ目の商品の設定をしてください");

          // 商品名の設定
          System.out.print("商品名を設定してください: ");
          String itemName = scan.nextLine();
          System.out.print("商品数を設定してください: ");
          int itemNum = scan.nextInt();
          scan.nextLine();
          System.out.print("価格を設定してください: ");
          int price = scan.nextInt();
          scan.nextLine();

          // コンストラクタに値をセットする
          AddPrice setItems = new AddPrice(itemName, itemNum, price);

          // Listに値をセットする
          stockList.add(setItems);

          // 追加処理を行うか否か
          // 判定を取得する
          System.out.print("続けて商品を追加しますか? (y/n): ");
          String nextStatus = scan.nextLine();
          if (nextStatus.equals("n")) {
            break;
          }
        }
      } else if (selectMenu == 2) {
        System.out.println("在庫一覧はこちら");
        // 在庫表の表示
        stocks(stockList);
      } else if (selectMenu == 3) {
        System.out.println("在庫一覧はこちら");
        // 在庫表の表示
        stocks(stockList);

        // 購入品の番号と数を取得
        System.out.print("商品ナンバーを選択してください: ");
        int stockNo = scan.nextInt();
        scan.nextLine();
        System.out.print("購入数を選択してください: ");
        int stockBuy = scan.nextInt();
        scan.nextLine();

        // 商品購入処理
        for (AddPrice pay : stockList) {
          // 商品の購入金額を格納する変数
          final int PAYMENT = stockBuy * pay.getPrice();

          System.out.print("お支払い金額は" + PAYMENT + "です");

          // 購入の確認
          System.out.print("購入しますか? (y/n)");
          String payStatus = scan.nextLine();
          if (payStatus.equals("n")) {
            System.out.println("購入をキャンセルしました。");
            break;
          }

          // yを選んだ場合
          // 金額を入力させる
          System.out.print("金額を入力してください: ");
          int setMoney = scan.nextInt();
          scan.nextLine();

          if (setMoney > PAYMENT) {
            int change = setMoney - PAYMENT;
            System.out.println("購入完了しました。お釣りは" + change + "円です。");
            // 在庫から選択された商品の数を減らして
            // 番号と一致する配列を上書きする
            int i = 1;
            for (AddPrice stocks : stockList) {
              if (stockNo == i) {
                AddPrice setItems = new AddPrice(stocks.getItemName(), stocks.getItemNum() - stockBuy,
                    stocks.getPrice());
                stockList.set((stockNo - 1), setItems);
              }
              i++;
            }
            // 更新があれば配列を再度表示する
            stocks(stockList);
          } else {
            System.out.println("購入に失敗しました。");
          }
        }

        System.out.print("続けて商品を購入しますか? (y/n): ");
        String buyStatus = scan.nextLine();
        if (buyStatus.equals("n")) {
          System.out.println("ご利用ありがとうございました。");
          break;
        }
      } else if (selectMenu == 9) {
        System.out.println("またのご来店をお待ちしております。");
        break;
      }
    }
  }

  // 在庫一覧を表示するメソッド
  public static void stocks(List<AddPrice> stockItems) {
    System.out.println("在庫一覧を表示する");

    // 在庫表を表示
    System.out.println("商品No." + " 在庫数 " + " 商品名 " + " 価格 ");
    System.out.println("-------------------------------------");
    // 商品ナンバーのデフォルト値を設定
    int i = 1;
    for (AddPrice stocks : stockItems) {
      System.out
          .println(i + "        " + stocks.getItemNum() + "      " + stocks.getItemName() + "  " + stocks.getPrice());
      // 商品ナンバーをインクリメント
      i++;
    }
    System.out.println("-------------------------------------");
  }
}
