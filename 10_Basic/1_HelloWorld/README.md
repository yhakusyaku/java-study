# ハローワールド

## 目的
- Javaプロジェクトを作成
- コンパイルしJarファイルを生成

## 手順

### IDEダウンロード

- [Eclipse](https://mergedoc.osdn.jp/)
- [Visual Studio Code](https://code.visualstudio.com/) + [Java Extention](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

いずれかの開発用ソフトウェアを準備してください。

※ 以下の手順は、Eclipseで進めます。

### プロジェクト作成

1. プロジェクト追加

    1. Eclipse起動
        ![alt](./image/001_EclipseStart.png)
    1. ファイル->Javaプロジェクトをクリック
        ![alt](./image/002_プロジェクト追加.png)
    1. 新規プロジェクト設定

        ※デフォルト値以外のものを記載
        |設定名|値|備考|
        |-----|--|--|
        |プロジェクト名|HellowWorld|※任意の名前|
        |JRE|プロジェクト固有のJREを仕様:java8|※Javaのバージョンは適時変更してください。|

        ![alt](./image/003_プロジェクト設定.png)

        変更しないで完了
        ![alt](./image/004_プロジェクト設定.png)

    1. プロジェクト追加結果
        ![alt](./image/005_プロジェクト追加.png)

1. メインクラス作成
    1. プロジェクトを右クリック->新規->クラスを選択
        ![alt](./image/006_プロジェクト追加.png)

    1. 新規Javaクラス設定
        ![alt](./image/007_メインクラス追加.png)

        ※デフォルト値以外のものを記載
        |設定名|値|備考|
        |-----|--|--|
        |パッケージ名|hellowworld|※任意の名前|
        |名称|ApplicationMain|※任意の名前|
        |public static void main(String[] args)(v)|チェック|プログラム起動時最初に呼び出されることになるメソッドを自動作成 ※自分で記述しても問題ありません。|
        
        追加結果
        ![alt](./image/008_メインクラス追加.png)

1. HellowWorld出力プログラム作成
    1. main メソッドに、標準出力にHellowWorldと出力するプログラムを追記
        ``` Java
            public static void main(String[] args) {
                //コンソール出力追加
                System.out.println("Hellow World");
            }
        ```
    1. 実行
        エディタ上で右クリックし、実行->Javaアプリケーションを選択する。
        ![alt](./image/010_プログラム実行.png)

        出力結果は左下のコンソールに出力
        ![alt](./image/011_実行結果.png)

1. 実行ファイル作成
    1. プロジェクトを右クリックし、エクスポートを選択
        ![alt](./image/010_プログラム実行.png)

    1. 実行可能Jarファイルを選択
        ![alt](./image/012_エクスポート_実行可能Jarファイル.png)

    1. 実行可能Jarファイル設定
        ![alt](./image/013_エクスポート_実行可能Jarファイル.png)
        |設定名       |値                        |備考                         |
        |------------|--------------------------|----------------------------|
        |起動構成     |ApplicationMain -HelloWorld|{メインクラス名}-{プロジェクト名}|
        |エクスポート先|※任意の出力先| |

1. Jarファイルの起動
    以下のコマンドを実行し、プログラムを起動してください。

    ```
        java -jar .\HelloWorld.jar
    ```
    ![alt](./image/014_Jarファイル実行.png)

