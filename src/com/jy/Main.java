package com.jy;

public class Main {

	public static void main(String[] args) {
		// 前序遍历
		int[] preOrder = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
		// 中序遍历
		int[] inOrder = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };

		System.out.println("----------重建之前----------");
		System.out.print("前序遍历序列:");
		for (int i : preOrder)
			System.out.print(i + " ");

		System.out.println();

		System.out.print("中序遍历序列:");
		for (int i : inOrder)
			System.out.print(i + " ");
		System.out.println();

		System.out.println("----------重建之后----------");
		// 重构二叉树
		TreeNode root = construct(preOrder, inOrder);
		// 打印二叉树检查重构的结构
		System.out.print("前序遍历输出:");
		printPreOrder(root);
		System.out.println();
		System.out.print("中序遍历输出:");
		printInOrder(root);
	}

	/**
	 * 重建二叉树
	 * 
	 * @param preOrder
	 *            前序遍历数组
	 * @param inOrder
	 *            中序遍历数组
	 * @return 重建的二叉树的根节点
	 */
	private static TreeNode construct(int[] preOrder, int[] inOrder) {
		// 鲁棒性检查
		if (preOrder == null || inOrder == null || preOrder.length <= 0)
			return null;
		return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}

	/**
	 * 重建二叉树
	 * 
	 * @param preOrder
	 *            前序遍历数组
	 * @param startPreOrder
	 *            前序遍历开始的位置
	 * @param endPreOrder
	 *            前序遍历结束的位置
	 * @param inOrder
	 *            中序遍历数组
	 * @param startInOrder
	 *            中序遍历开始的位置
	 * @param endInOrder
	 *            中序遍历结束的位置
	 * @return 重建的二叉树的根节点
	 */
	private static TreeNode construct(int[] preOrder, int startPreOrder, int endPreOrder, int[] inOrder,
			int startInOrder, int endInOrder) {
		// 前序遍历的第一个节点是根节点
		int rootValue = preOrder[startPreOrder];
		// 根节点
		TreeNode root = new TreeNode();
		root.mValue = rootValue;
		root.mLeft = root.mRight = null;

		if (startPreOrder == endPreOrder) {
			if (startInOrder == endInOrder && preOrder[startPreOrder] == inOrder[startInOrder]) {
				// 找到叶子节点
				return root;
			} else {
				throw new RuntimeException("Invalid Input!");
			}
		}

		// 在中序遍历中找到根节点的位置
		int indexOfRootInOrder = startInOrder;
		while (indexOfRootInOrder <= endInOrder && inOrder[indexOfRootInOrder] != rootValue)
			indexOfRootInOrder++;

		// 鲁棒性检查
		// 当得到的根节点是中序遍历的最后一个节点时，是否等于前序遍历中得到的根节点的值
		if (indexOfRootInOrder > endInOrder)
			throw new RuntimeException("Invalid Input!");

		// 中序遍历中用根节点分段，左子树的长度
		int leftLength = indexOfRootInOrder - startInOrder;
		// 前序遍历中用根节点划分，左子树的结束位置
		int leftPreOrderEnd = startPreOrder + leftLength;

		// 递归得到左、右子树
		if (leftLength > 0)
			root.mLeft = construct(preOrder, startPreOrder + 1, leftPreOrderEnd, inOrder, startInOrder,
					indexOfRootInOrder - 1);
		if (leftLength < endPreOrder - startPreOrder)
			root.mRight = construct(preOrder, leftPreOrderEnd + 1, endPreOrder, inOrder, indexOfRootInOrder + 1,
					endInOrder);
		return root;
	}

	/**
	 * 中序遍历打印二叉树
	 * 
	 * @param root
	 *            二叉树的根节点
	 */
	private static void printInOrder(TreeNode root) {
		// 采用递归的方式遍历
		if (root != null) {
			printInOrder(root.mLeft);
			System.out.print(root.mValue + " ");
			printInOrder(root.mRight);
		}
	}

	/**
	 * 前序遍历打印二叉树
	 * 
	 * @param root
	 *            二叉树的根节点
	 */
	private static void printPreOrder(TreeNode root) {
		// 采用递归的方式遍历
		if (root != null) {
			System.out.print(root.mValue + " ");
			printPreOrder(root.mLeft);
			printPreOrder(root.mRight);
		}
	}

}
