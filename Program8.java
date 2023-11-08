package prog8;
/*
* Author: Reed Elliott
* Purpose: Program 8 Main
* */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math;
import java.util.stream.Stream;

public class Program8 {

	public static void main(String[] args) throws IOException {
		// read in data
		BufferedReader reader = new BufferedReader(new FileReader("dracula.txt"));
		Stream<String> inStream = reader.lines();

		// initialize tree
		BTree bTree = new BTree();

		// for each line of the file
		inStream.forEach(s -> {
			// for each word in the line
			String[] words = s.split(" ");

			// lowercase everything and only keep letters
			for (String word : words) {
				String sanitized = word.toLowerCase().replaceAll("[^a-z]", "");
				// if we have a non-empty line, add to the tree
				if (!sanitized.isEmpty())
					bTree.insert(sanitized);
			}

		});

		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("analysis.txt")));

		long nodeCount = bTree.getNodeCount();
		long height = bTree.getHeight();
		long maxNodes = (long) Math.pow(2, height) - 1;
		long log2height = (long) Math.ceil(Math.log(nodeCount) / Math.log(2));

		writer.println("Analysis of dracula.txt");
		writer.print("Total Nodes: ");
		writer.println(nodeCount);
		writer.print("Height of a balanced tree with that many nodes: ");
		writer.println(log2height);
		writer.print("Tree Depth: ");
		writer.println(height);
		writer.print("Max Possible Tree Nodes with that height: ");
		writer.println(maxNodes);
		writer.print("Efficiency % (BalancedTreeDepth/CurrentDepth): ");
		// using float because we don't need that many
		// decimal points
		writer.print(100*((float)log2height/height));
		writer.println('%');

		reader.close();
		writer.close();
	}

}
