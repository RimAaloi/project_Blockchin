module org.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    //requires core;
    //requires abi;
    //requires crypto;
    //requires io.reactivex.rxjava2;
    //requires tuples;
    requires kernel;
    requires layout;


    opens org.example.demo1 to javafx.fxml;
    exports org.example.demo1;
}