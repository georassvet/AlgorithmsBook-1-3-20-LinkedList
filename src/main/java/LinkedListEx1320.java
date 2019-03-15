import java.util.Iterator;

public class LinkedListEx1320<Item> implements Iterable<Item> {

        private Node first;
        private Node last;
        private int size;

        public boolean isEmpty(){
            return  first==null;
        }

        public int getSize(){
            return size;
        }


        public void addFirst(Item item){
            Node node = new Node();
            node.item = item;
            if(isEmpty()){
                first = node;
                last=node;
            }else{
                first.prev = node;
                node.next = first;
                first = node;
            }
            size++;
        }
        public void addLast(Item item){
            Node node = new Node();
            node.item = item;
            if(isEmpty()){
                first = node;
                last=node;
            }else{
                last.next=node;
                node.prev = last;
                last = node;
            }
            size++;
        }
        private Node getNode(int i){
            if(i <= size - 1){
                Node node =null;
                if(i>size/2){
                    node = last;
                    for(int j=size-1; j!=i ;j--){
                        node = node.prev;
                    }
                }else{
                    node =first;
                    for(int j=0; j!=i ;j++){
                        node = node.next;
                    }
                }
                return node;
            }
            else{
                return null;
            }
        }

        public void addAfter(int i,Item item){
            Node node = getNode(i);
            if(node!=null){
                Node newNode = new Node();
                newNode.item = item;
                newNode.prev = node;
                newNode.next = node.next;
                node.next=newNode;
            }
            else {
                System.out.println("Node not found");
            }
            size++;
        }
        public void addBefore(int i,Item item){
            Node node = getNode(i);
            if(node!=null){
                Node newNode = new Node();
                newNode.item = item;
                Node prevNode = node.prev;
                newNode.next = node;
                newNode.prev = node.prev;
                node.prev = newNode;
                prevNode.next=newNode;
            }
            else {
                System.out.println("Node not found");
            }
            size++;
        }
        public void delete(int i){
            Node node = getNode(i);
            if(node!=null){
                Node nodePrev = node.prev;
                Node nodeNext = node.next;
                nodePrev.next = node.next;
                nodeNext.prev = node.prev;
                node.prev = null;
                node.next = null;
            }
            else {
                System.out.println("Node not found");
            }
            size--;
        }

        @Override
        public Iterator<Item> iterator() {
            return new Iterator<Item>() {
                Node node =first;
                @Override
                public boolean hasNext() {
                    return node!=null;
                }

                @Override
                public Item next() {
                    Item item = node.item;
                    node=node.next;
                    return item;
                }
            };
        }

        private class Node{
            private Item item;
            private Node next;
            private Node prev;
        }
    }
