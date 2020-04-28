package cww331;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static class  TreeNode{
       public int val;
       public TreeNode left;
       public  TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList <>();
        if(root==null){    //空树返回一个空的List,
            return result;
        }
        //访问根节点，把元素添加到List中
        result.add(root.val);
        result.addAll(preOrderTraversal(root.left));
        result.addAll(preOrderTraversal(root.right));
    }
    public static Node find(Node root,char toFind){   //查找元素是否存在
        if(root==null){
            return null;
        }
        if(root.val== toFind){
            return root;
        }
        Node result = find(root.left,toFind);
        if(result!=null){
            return result;
        }
        return find(root.right,toFind);
    }
    public static int kLevelSize(Node root,int k){          //递归求第k层的节点个数
        if(k<1||root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return kLevelSize(root.right,k-1)+kLevelSize(root.left,k-1);
    }
}
