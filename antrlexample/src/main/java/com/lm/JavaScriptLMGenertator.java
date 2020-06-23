package com.lm;

import com.ngram.model;
import com.wxj.demo.NodeUtis;
import com.wxj.demo.Seed;
import com.wxj.demo.TreeNode;

import java.util.List;

public class JavaScriptLMGenertator implements Generator {

    private Seed fuzztree;
    private Seed croptree;
    private model Model;
    private int n;


    public JavaScriptLMGenertator(model Model,int n){
        this.Model=Model;
        this.n = n;

    }

    public void init(Seed fuzztree, Seed croptree){
        this.fuzztree = fuzztree;
        this.croptree = croptree;

    }
    @Override
    public String generate() {
        TreeNode fuzztreeroot = fuzztree.getRoot();
        TreeNode croproot = croptree.getRoot();

        List<TreeNode> fuzznode = NodeUtis.getMaxProbabilitynode(fuzztreeroot,Model,n);
        System.out.println(fuzznode);

        TreeNode first =fuzznode.get(0);
        List<TreeNode> repalacenode = croproot.getstatemetnodelist(first.getStatement());
        System.out.println(repalacenode);

        NodeUtis.replace(fuzznode.get(0),repalacenode.get(1));

        return fuzztreeroot.gettext();
    }


}
