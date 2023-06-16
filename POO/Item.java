import java.util.ArrayList;

public class Item {
    private ArrayList<String> carrinho;

    public Item() {
        carrinho = new ArrayList<>();
    }

    public void adicionar_item(String item) {
        carrinho.add(item);
    }
}
