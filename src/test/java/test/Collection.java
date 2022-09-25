package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class Collection {
	public static void main(String[]args) {
//		ArrayList list = new ArrayList();
//		list.add("Velocity");
//		list.add(10);
//		list.add('q');
//		list.add(null);
//		list.add(100.5);
//		list.add(null);
//		list.add(10);
//		
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
//		System.out.println(list.get(3));
//		System.out.println(list.get(4));
//		System.out.println(list.get(5));
//		System.out.println(list.get(06));

//		Vector<Integer> v = new Vector<Integer>();
//		v.add(1);
//		v.add(20);
//		v.add(null);
//		v.add(20);
//		Iterator i = v.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//	}
			
//			HashSet hs = new HashSet();
//			hs.add("Velocity");
//			hs.add('d');
//			hs.add(null);
//			hs.add(null);
//			hs.add("Velocity");
//			
//			Iterator i = hs.iterator();
//			while(i.hasNext()) {
//				System.out.println(i.next());
//			}
		
//		HashMap hm = new HashMap ();
//		hm.put(1, "Velocity");
//		hm.put('a', "50");
//		hm.put(null, null);
//		hm.put(null, "Hello");
//		hm.put(2, "Velocity");
//		
//		System.out.println(hm.get(null));
//		System.out.println(hm.get(1));
//		System.out.println(hm.get('a'));
//		System.out.println(hm.get(2));

		Hashtable<Integer,String> ht = new Hashtable<Integer, String>();
		ht.put(1, "Hello");
		ht.put(2, "My");
		ht.put(4, "Name");
		ht.put(5, "is");
		ht.put(8, "Ganesh");
		
		System.out.println(ht.get(1));
		System.out.println(ht.get(2));
		System.out.println(ht.get(4));
		System.out.println(ht.get(5));
		System.out.println(ht.get(8));

		}
}

