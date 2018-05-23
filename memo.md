- onCreateメソッド内のsetContentViewメソッドにXMLを指定する。
- インテントを作成->遷移先を指定->インテントを送るというのが画面遷移の基本的な流れ
- onClickの最後はstartActivity(intent)で終わることが多いっぽい
- intentを送る場合も受ける場合も、まずは空のintentを生成する（データを受け取らない場合は生成しない）
- インテントを送る時はデータの型気にしなくていいけど、受ける時は気にしてメソッドを変えないといけない。getIntExtraとかgetShortArrayExtraとか。
- getStringExtra等のインテントからデータを取り出すメソッドがnullを返す可能性がある場合、必ずnullチェックをしてNullPointerExceptionを避ける。
- onCreateなどのメソッドは、必ず実行されるものとされないものがある。onCreate(), onStart(), onResume(), onPause()は基本的に必ず実行されるが、onStop(), onDestroy()は必ず実行されるわけではない。なのでデータの保存などはonPause()でやる。
- TOASTはmakeText()がオブジェクトを作成し、show()が表示する。
- AndroidではリソースのXML内で「android:id=」という指定で要素に名前を付けると、自動的に「R.java」というint型の変数が自動的に作成される。
- setOnClickListenerメソッドでOnClickListenerを登録して、その中でonClickを定義する。

```java
        bt_toSub2.setOnClickListener(new View.OnClickListener() {
```

- EditTextの内容を、ボタン押下時に取得するためには、onClickの中でgetText().toString()のようにして取得する。

```java
                String message = et_message.getText().toString();
```
