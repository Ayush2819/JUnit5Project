package streamdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

//java program to filter Collection of user defined objects using Stream
public class StreamExample4 {

	public static void main(String[] args) {
		
		List<Book> list=new ArrayList<Book>();

		//Creating Books
		Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);
		Book b2=new Book(102,"Data Communications and Networking","Forouzan","Mc Graw Hill",4);
		Book b3=new Book(103,"Operating System","Galvin","Wiley",6);
		Book b4=new Book(104,"java [rogramming","james gosling","Wiley",15);
		Book b5=new Book(105,"Spring Framework","Rod Johnson","BPB",5);


		//Adding Books to list
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		
		List<Integer> list1=list.stream().filter(b -> b.quantity >7)//filter data
					.map(b->b.quantity) //fetch quantity
					.collect(Collectors.toList());
		System.out.println("Books with quantity greater then 7");
		System.out.println(list1);
		
		System.out.println("Books Details with quantity greater then 7");
		list.stream().filter(b-> b.quantity >7).forEach(b->System.out.println(b.id+" "+b.name+ " "+b.author+" "+b.publisher+b.quantity));
		
		
		//reduce method
		int totalqty = list.stream().map(b->b.quantity).reduce(0,(sum,qty)->sum+qty);
		System.out.println("Total quantity of Books: "+totalqty);
		
		//max and min method()
		Book bk1=list.stream().max((book1,book2) ->book1.quantity > book2.quantity ? 1: -1).get();
		System.out.println("Maximum quantity of Books: "+bk1.quantity);
		
		Book bk2=list.stream().min((book1,book2) ->book1.quantity > book2.quantity ? 1: -1).get();
		System.out.println("Minimum quantity of Books: "+bk2.quantity);
		
		//count()
		
		long count=list.stream().count();
		System.out.println("Total no. of Books: "+count);
		
		long count1=list.stream().filter(b ->b.quantity <7).count();
		System.out.println("Total Books with quantity less then 7: "+ count1);
	}
	
	

}
