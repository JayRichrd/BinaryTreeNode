package com.jy;

public class Main {

	public static void main(String[] args) {
		// 前序遍历
		int[] preOrder = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
		// 中序遍历
		int[] inOrder = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };
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
		return construct(preOrder, preOrder.length - 1, inOrder, inOrder.length - 1);
	}

	/**
	 * 重建二叉树
	 * 
	 * @param startPreOrder
	 *            前序遍历起点
	 * @param indexOfEndPreOrder
	 *            前序遍历最后一个元素在数组中的索引
	 * @param startInOrder
	 *            中序遍历起点
	 * @param indexOfEndInOrder
	 *            中序遍历最后一个元素在数组中的索引
	 * @return 重建的二叉树的根节点
	 */
	private static TreeNode construct(int[] startPreOrder, int indexOfEndPreOrder, int[] startInOrder,
			int indexOfEndInOrder) {
		return null;
	}

}
