import java.util.Iterator;

public class LinkedListEx1320Client {
        public static void main(String[] args) {
            LinkedListEx1320<String> ex1320 = new LinkedListEx1320<>();
            String[] string = "главное ввязаться в драку а там посмотрим".split(" "); //7
            for (int i = 0; i <=string.length-1 ; i++) {
                ex1320.addFirst(string[i]);
            }
            ex1320.addLast("Last");
            show(ex1320);

            ex1320.addFirst("Каша");
            ex1320.addLast("Макароны");
            show(ex1320);
            ex1320.addAfter(2,"Позиция 2");
            show(ex1320);
            ex1320.addBefore(ex1320.getSize()-1,"Позиция last" );
            show(ex1320);
            ex1320.delete(1);
            show(ex1320);
        }
        public  static <Item> void show(LinkedListEx1320<Item> ex1320 ){
            Iterator<Item> stringIterator = ex1320.iterator();
            for (Item s : ex1320
                    ) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
