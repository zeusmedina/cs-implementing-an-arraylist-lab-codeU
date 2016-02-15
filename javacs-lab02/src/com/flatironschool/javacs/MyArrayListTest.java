/**
 * 
 */
package com.flatironschool.javacs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author downey
 *
 */
public class MyArrayListTest {

	private MyArrayList<Integer> mal;
	private ArrayList<Integer> list = new ArrayList<Integer>();


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list.add(1);
		list.add(2);
		list.add(3);
		
		mal = new MyArrayList<Integer>();
		mal.addAll(list);
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#MyArrayList()}.
	 */
	@Test
	public void testMyArrayList() {
		assertEquals(3, mal.size());
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddT() {
		assertEquals(new Integer(2), mal.get(1));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntT() {
		mal.add(1, 5);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertEquals(new Integer(5), mal.get(1));
		assertEquals(4, mal.size());
		
		try {
		    mal.set(-1, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mal.set(4, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good
		
		mal.add(0, 6);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertEquals(new Integer(6), mal.get(0));

		mal.add(5, 7);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertEquals(new Integer(7), mal.get(5));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#addAll(java.util.Collection)}.
	 */
	@Test
	public void testAddAllCollectionOfQextendsT() {
		mal.addAll(list);
		mal.addAll(list);
		mal.addAll(list);
		assertEquals(12, mal.size());
		assertEquals(new Integer(3), mal.get(5));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#clear()}.
	 */
	@Test
	public void testClear() {
		mal.clear();
		assertEquals(mal.size(), 0);
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		assertTrue(mal.contains(1));
		assertFalse(mal.contains(4));
		assertFalse(mal.contains(null));
		mal.add(null);
		assertTrue(mal.contains(null));

	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#containsAll(java.util.Collection)}.
	 */
	@Test
	public void testContainsAll() {
		assertTrue(mal.containsAll(list));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#get(int)}.
	 */
	@Test
	public void testGet() {
		assertEquals(mal.get(1), new Integer(2));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void testIndexOf() {
		assertEquals(mal.indexOf(1), 0);
		assertEquals(mal.indexOf(2), 1);
		assertEquals(mal.indexOf(3), 2);
		assertEquals(mal.indexOf(4), -1);
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertFalse(mal.isEmpty());
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#iterator()}.
	 */
	@Test
	public void testIterator() {
		Iterator<Integer> iter = mal.iterator();
		assertEquals(iter.next(), new Integer(1));
		assertEquals(iter.next(), new Integer(2));
		assertEquals(iter.next(), new Integer(3));
		assertFalse(iter.hasNext());
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#lastIndexOf(java.lang.Object)}.
	 */
	@Test
	public void testLastIndexOf() {
		mal.add(2);
		assertEquals(3, mal.lastIndexOf(new Integer(2)));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveObject() {
		boolean flag = mal.remove(new Integer(2));
		assertTrue(flag);
		assertEquals(2, mal.size());
		assertEquals(new Integer(3), mal.get(1));
		//System.out.println(Arrays.toString(mal.toArray()));

		flag = mal.remove(new Integer(1));
		assertTrue(flag);
		assertEquals(1, mal.size());
		assertEquals(new Integer(3), mal.get(0));
		//System.out.println(Arrays.toString(mal.toArray()));
		
		flag = mal.remove(new Integer(5));
		assertFalse(flag);
		assertEquals(1, mal.size());
		assertEquals(new Integer(3), mal.get(0));
		//System.out.println(Arrays.toString(mal.toArray()));
		
		flag = mal.remove(new Integer(3));
		assertTrue(flag);
		assertEquals(0, mal.size());
		//System.out.println(Arrays.toString(mal.toArray()));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		Integer val = mal.remove(1);
		assertEquals(new Integer(2), val);
		assertEquals(2, mal.size());
		assertEquals(new Integer(3), mal.get(1));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#removeAll(java.util.Collection)}.
	 */
	@Test
	public void testRemoveAll() {
		mal.removeAll(list);
		assertEquals(0, mal.size());
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		Integer val = mal.set(1, 5);
		assertEquals(new Integer(2), val);

		val = mal.set(0, 6);
		assertEquals(new Integer(1), val);

		val = mal.set(2, 7);
		assertEquals(new Integer(3), val);

		// return value should be 2
		// list should be [6, 5, 7]
		assertEquals(new Integer(6), mal.get(0));
		assertEquals(new Integer(5), mal.get(1));
		assertEquals(new Integer(7), mal.get(2));
		//System.out.println(Arrays.toString(mal.toArray()));

		try {
		    mal.set(-1, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mal.set(4, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good
}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#size()}.
	 */
	@Test
	public void testSize() {
		assertEquals(3, mal.size());
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#subList(int, int)}.
	 */
	@Test
	public void testSubList() {
		mal.addAll(list);
		List<Integer> sub = mal.subList(1, 4);
		assertEquals(new Integer(3), sub.get(1));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#toArray()}.
	 */
	@Test
	public void testToArray() {
		Object[] array = mal.toArray();
		assertEquals(1, array[0]);
	}

}
