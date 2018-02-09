/****************************************************
 * Kevin Jimenez 
 * The University of Texas at El Paso
 * CS2302 Data Structures
 * Lab 3
 * Professor Olac Fuentes
 ****************************************************/
import java.util.Scanner;

public class LinkListSort {
	
	public static void main (String args[]){
		int amount;
		Scanner input = new Scanner (System.in);
		System.out.println("Please type the number of integers you want on the list");
		amount=input.nextInt();
		if (amount>0){
			iNode L = new iNode((int)(Math.random()*10),null);
			for (int i=1; i<amount; i++){
				L = new iNode((int)(Math.random()*10),L);
			}

			for (iNode t=L;t!=null;t=t.next){
				System.out.println(t.item);
			}
			iNode bubbleSort = SortListC(L);
			System.out.println("Bubble Sort");
			for (iNode x=bubbleSort;x!=null; x=x.next ){
				System.out.println(x.item+" *");
			}
			iNode mergeNode = mergeSort(L);
			System.out.println("Merge Sort");
			for (iNode x=mergeNode;x!=null; x=x.next ){
				System.out.println(x.item+" ***");
			}
			//second method
			iNode 	quickNode = SortListB(L);
			System.out.println("Quick Sort");
			for (iNode x=quickNode;x!=null; x=x.next ){
				System.out.println(x.item+" **");
			}


		}
		else
			System.out.println("Sorry but the number of integers must be greater than 0");

	}

	private static iNode mergeSort(iNode L){
	 //** The method for sorting the numbers *//*
		iNode L1 = null;
		iNode L2 = null;
		if (L==null||L.next==null)
			return L;

		iNode t=L;
		for (t=L;t!=null&&t.next!=null; t=t.next.next ){
			L1 = new iNode(t.item,L1);
			//			System.out.println(t.item+" L1");
		}
		if(t!=null)
		{
			L1 = new iNode(t.item,L1);
			//			System.out.println(t.item+" L1");
		}


		for (t=L.next;t!=null&&t.next!=null; t=t.next.next ){
			L2 = new iNode(t.item,L2);
			//			System.out.println(t.item+" L2");
		}
		if(t!=null)
		{
			L2 = new iNode(t.item,L2);
			//			System.out.println(t.item+" L2");
		}
		L1=mergeSort(L1);
		L2=mergeSort(L2);


		return merge(L1,L2);
	}
	public static iNode merge(iNode a, iNode b) { 
		iNode temp = new iNode(0,null); 
		iNode head = temp;
		iNode c = head; 
		while ((a != null) && (b != null)) 
		{
			if (a.item <= b.item) 
			{ 
				c.next = a; 
				c = a; 
				a = a.next; 
			} 
			else
			{ 
				c.next = b; 
				c = b; 
				b = b.next;
			} 
		}

		if (a==null)
			c.next= b;
		else 
			c.next=a;

		return head.next; 
	} 

	public static iNode SortListB(iNode L){
		iNode L1 = null;
		iNode L2 = null;
		if (L!=null){
			for (iNode D=L.next;D!=null;D=D.next){
				if (D.item<L.item){
					L1= new iNode (D.item,L1);
				}
				else {
					L2= new iNode (D.item, L2);
				}
			}

			L1 = SortListB(L1);
			L2 = SortListB(L2);
			L.next=L2;
			L=concatenate(L1,L);
		}
		return L;
	}

	public static iNode concatenate (iNode L1,iNode L){
		iNode LL;
		if (L1==null){
			return L;
		}
		for (LL=L1; LL.next!=null;LL=LL.next){
		}
		LL.next=L;

		return L1;
	}

	public static iNode SortListC(iNode L){	
		int len = 0;
		iNode temp=null;
		iNode head=L;
		for (iNode t=L; t!=null; t=t.next){
			len++;
		}
		for (int i = 1; i<len-1; i++){
			int cur= 0;
			for ( temp=L; temp.next!=null; temp=temp.next){ 
				if (temp.item > temp.next.item){
					cur = temp.item;
					temp.item=temp.next.item;
					temp.next.item=cur;
				}

			}
			L=head;
		}
		return L;
	}
}
	  

