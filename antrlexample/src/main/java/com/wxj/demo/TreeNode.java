package com.wxj.demo;

import org.antlr.v4.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TreeNode {

    public String  statement  ;

    public TreeNode parent;

    public List<TreeNode>  chlidren = new ArrayList<TreeNode>();

    private List<List<TreeNode>> allpath = new ArrayList<>();


    public TreeNode(String statement) {
        this.statement = statement;
    }

    public TreeNode(String statement, TreeNode parent, List<TreeNode> chlidren) {
        this.statement = statement;
        this.parent = parent;
        this.chlidren = chlidren;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(statement, treeNode.statement) &&
                Objects.equals(parent, treeNode.parent) &&
                Objects.equals(chlidren, treeNode.chlidren);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statement, parent, chlidren);
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "statement='" + statement + '\'' +
                '}';
    }

    public TreeNode getParent() {
        return parent;
    }

    public List<TreeNode> getChlidren() {
        return chlidren;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public void setChlidren(List<TreeNode> chlidren) {
        this.chlidren = chlidren;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public int getchildrencount(){
        return chlidren.size();
    }
    //得到从该节点遍历的text
    public String gettext(){
        if(this.getchildrencount()==0){
            if(!"<EOF>".equals(this.getStatement()))
            return this.getStatement();
            else
                return "";
        }
        else{
            StringBuilder builder = new StringBuilder();
            for(int i = 0 ;i<this.getchildrencount();i++){
                if (i > 0) {

                    builder.append(" ");
                }
                builder.append(this.getChlidren().get(i).gettext());
            }
            return builder.toString();
        }
    }

    public List<TreeNode> getancestor(TreeNode treeNode){
        if (treeNode.getParent() == null) {
            return Collections.emptyList();
        } else {
            List<TreeNode> ancestors = new ArrayList();

            for(treeNode = treeNode.getParent(); treeNode!= null; treeNode = treeNode.getParent()) {
                ancestors.add(0,treeNode);
            }

            return ancestors;
        }
    }

    public List<List<TreeNode>> getpath(TreeNode treeNode){

        if(treeNode.getchildrencount()==0){
            List<TreeNode> path = treeNode.getancestor(treeNode);
            path.add(treeNode);
            allpath.add(path);
        }
        else {
            for(int i = 0;i<treeNode.getchildrencount();i++){
                getpath(treeNode.getChlidren().get(i));
            }
        }
        return allpath;
    }
}
