QUESTION BANK

1.	What is the time complexity and space complexity of the below code:
a.	int a = 0, i = N;
b.	vector<int> arr;
c.	while (i > 0) {
d.	    a += i;
e.	    i /= 2;
f.	    arr.push_back(i);
g.	}
int a = 0, i = N;
vector<int> arr;
while (i > 0) {
a += i;
i /= 2;
arr.push_back(i);
}

2.	Imagine you have a linked list that represents a series of tasks you need to complete. You want to know how many tasks are in your list so you can plan your day better. Given that the linked list is already built and you have access to its head node, how would you implement a function to calculate the total number of tasks in the list?

Write a pseudocode for a function called “lengthOfLinkedList(Node* head)”that determines the length of this linked list.
#include <iostream>
using namespace std;

// Definition of a singly linked list node
struct Node {
    string task;
    Node* next;

    Node(string t) : task(t), next(nullptr) {}
};

// Function to count the number of tasks in the linked list
int countTasks(Node* head) {
    int count = 0;
    Node* current = head; // Start from the head node
    while (current != nullptr) {
        count++;            // Increment count for each node
        current = current->next; // Move to the next node
    }
    return count;
}

// Function to add a task at the end of the linked list
void appendTask(Node*& head, string task) {
    Node* newNode = new Node(task);
    if (head == nullptr) {
        head = newNode;
        return;
    }
    Node* temp = head;
    while (temp->next != nullptr) {
        temp = temp->next;
    }
    temp->next = newNode;
}

// Function to print tasks
void printTasks(Node* head) {
    Node* temp = head;
    while (temp != nullptr) {
        cout << temp->task << " -> ";
        temp = temp->next;
    }
    cout << "NULL\n";
}

// Driver code
int main() {
    Node* head = nullptr;
    
    // Adding tasks to the list
    appendTask(head, "Complete DSA assignment");
    appendTask(head, "Prepare for meeting");
    appendTask(head, "Go to the gym");
    appendTask(head, "Read a book");

    // Print tasks
    printTasks(head);

    // Count and display the number of tasks
    cout << "Total number of tasks: " << countTasks(head) << endl;

    return 0;
}



3.	Suppose you have a chain of people standing in a line, where each person holds the hand of the next person. You start at the first person and want to greet everyone in the line, but you can only move forward one person at a time. What would be the time complexity of this process, similar to traversing a linked list?
#include <iostream>
using namespace std;

// Definition of a singly linked list node (Person in the line)
struct Person {
    string name;
    Person* next;
    
    // Constructor to initialize the person's name and set next to nullptr
    Person(string personName) : name(personName), next(nullptr) {}
};

// Function to traverse the linked list and greet each person
void greetEveryone(Person* head) {
    Person* current = head; // Start at the first person
    while (current != nullptr) {
        cout << "Hello, " << current->name << "!" << endl; // Greet the person
        current = current->next; // Move to the next person
    }
}

// Function to add a new person to the end of the linked list
void addPerson(Person*& head, string name) {
    Person* newPerson = new Person(name);
    if (head == nullptr) {
        head = newPerson;
        return;
    }
    Person* temp = head;
    while (temp->next != nullptr) {
        temp = temp->next;
    }
    temp->next = newPerson;
}

// Driver code
int main() {
    Person* head = nullptr;

    // Adding people to the line
    addPerson(head, "Alice");
    addPerson(head, "Bob");
    addPerson(head, "Charlie");
    addPerson(head, "David");

    // Greet everyone in the line
    greetEveryone(head);

    return 0;
}

4.	Answer the following questions:
a.	Can you find the length of a linked list?
b.	In a doubly linked list, can you traverse the linked list from the end of the list to the start of the list?
c.	What is LIFO?
d.	What does one mean by Abstract Data Type?
e.	Which function is used to remove elements from a queue?
#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int val) : data(val), next(nullptr) {}
};

// Function to find the length of a linked list
int lengthOfLinkedList(Node* head) {
    int count = 0;
    Node* current = head;
    while (current != nullptr) {
        count++;
        current = current->next;
    }
    return count;
}

// Driver code
int main() {
    Node* head = new Node(10);
    head->next = new Node(20);
    head->next->next = new Node(30);

    cout << "Length of the linked list: " << lengthOfLinkedList(head) << endl;
    return 0;
}
5.	Name two types of tree traversal techniques. Write two differences between the two techniques.
#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int val) : data(val), left(nullptr), right(nullptr) {}
};

// Inorder Traversal (Left, Root, Right)
void inorderTraversal(Node* root) {
    if (root == nullptr) return;
    inorderTraversal(root->left);
    cout << root->data << " ";
    inorderTraversal(root->right);
}

// Postorder Traversal (Left, Right, Root)
void postorderTraversal(Node* root) {
    if (root == nullptr) return;
    postorderTraversal(root->left);
    postorderTraversal(root->right);
    cout << root->data << " ";
}

// Driver code
int main() {
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);

    cout << "Inorder Traversal: ";
    inorderTraversal(root);
    cout << endl;

    cout << "Postorder Traversal: ";
    postorderTraversal(root);
    cout << endl;

    return 0;
}
6.	What is BFS? Explain with the help of an example.
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// Function to perform BFS traversal
void BFS(int startNode, vector<vector<int>>& adjList, vector<bool>& visited) {
    queue<int> q;
    q.push(startNode);
    visited[startNode] = true;

    while (!q.empty()) {
        int node = q.front();
        q.pop();
        cout << node << " ";

        // Traverse all adjacent nodes
        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                q.push(neighbor);
                visited[neighbor] = true;
            }
        }
    }
}

int main() {
    int n = 6; // Number of nodes
    vector<vector<int>> adjList(n);

    // Creating an undirected graph
    adjList[0] = {1, 2};
    adjList[1] = {0, 3, 4};
    adjList[2] = {0, 5};
    adjList[3] = {1};
    adjList[4] = {1};
    adjList[5] = {2};

    vector<bool> visited(n, false);

    cout << "BFS Traversal starting from node 0: ";
    BFS(0, adjList, visited);
    cout << endl;

    return 0;
}
7.	What is DFS? Explain with the help of an example.
#include <iostream>
#include <vector>

using namespace std;

// Function to perform DFS traversal
void DFS(int node, vector<vector<int>>& adjList, vector<bool>& visited) {
    // Mark the node as visited and print it
    visited[node] = true;
    cout << node << " ";

    // Traverse all adjacent nodes
    for (int neighbor : adjList[node]) {
        if (!visited[neighbor]) {
            DFS(neighbor, adjList, visited);
        }
    }
}

int main() {
    int n = 6; // Number of nodes
    vector<vector<int>> adjList(n);

    // Creating an undirected graph
    adjList[0] = {1, 2};
    adjList[1] = {0, 3, 4};
    adjList[2] = {0, 5};
    adjList[3] = {1};
    adjList[4] = {1};
    adjList[5] = {2};

    vector<bool> visited(n, false);

    cout << "DFS Traversal starting from node 0: ";
    DFS(0, adjList, visited);
    cout << endl;

    return 0;
}
8.	What is an adjacency matrix? Give an example.
8
#include <iostream>
using namespace std;

#define V 4

void printMatrix(int graph[V][V]) {
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            cout << graph[i][j] << " ";
        }
        cout << endl;
    }
}

int main() {
    int graph[V][V] = {
        {0, 1, 2, 4},
        {1, 0, 3, 0},
        {2, 3, 0, 5},
        {4, 0, 5, 0}
    };

    printMatrix(graph);
    return 0;
}
9.	What is an adjacency list? Give an example.
9
#include <iostream>
#include <vector>
using namespace std;

class Graph {
    int V;
    vector<vector<int>> adj;

public:
    Graph(int vertices) {
        V = vertices;
        adj.resize(V);
    }

    void addEdge(int u, int v) {
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    void printGraph() {
        for (int i = 0; i < V; i++) {
            cout << i << " → ";
            for (int neighbor : adj[i]) {
                cout << neighbor << " ";
            }
            cout << endl;
        }
    }
};

int main() {
    Graph g(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(0, 4);
    g.addEdge(1, 3);
    g.addEdge(2, 3);
    g.addEdge(2, 5);
    g.addEdge(3, 5);

    g.printGraph();
    return 0;
}








10.	Write the BFS traversal starting from 4 of the below given graph. Also write the DFS traversal for the below graph starting from 3.
 10
#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <unordered_map>

using namespace std;

// BFS Function
void BFS(unordered_map<int, vector<int>> &graph, int start) {
    queue<int> q;
    unordered_map<int, bool> visited;

    q.push(start);
    visited[start] = true;

    while (!q.empty()) {
        int node = q.front();
        q.pop();
        cout << node << " ";

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                q.push(neighbor);
                visited[neighbor] = true;
            }
        }
    }
}

// DFS Function
void DFS(unordered_map<int, vector<int>> &graph, int start, unordered_map<int, bool> &visited) {
    cout << start << " ";
    visited[start] = true;

    for (int neighbor : graph[start]) {
        if (!visited[neighbor]) {
            DFS(graph, neighbor, visited);
        }
    }
}

int main() {
    unordered_map<int, vector<int>> graph = {
        {1, {2, 3}}, {2, {4, 5}}, {3, {6}}, {4, {}}, {5, {}}, {6, {}}
    };

    cout << "BFS starting from 4: ";
    BFS(graph, 4);
    cout << endl;

    cout << "DFS starting from 3: ";
    unordered_map<int, bool> visited;
    DFS(graph, 3, visited);
    cout << endl;

    return 0;
}
11.	Write the Best case, average case and worst case time complexity of the below algorithms:
a.	Bubble Sort
b.	Selection Sort
c.	Insertion Sort
d.	Merge Sort
e.	Quick Sort
11
#include <iostream>
#include <vector>
using namespace std;

// Function to print array
void printArray(vector<int> &arr) {
    for (int num : arr)
        cout << num << " ";
    cout << endl;
}

// Bubble Sort
void bubbleSort(vector<int> &arr) {
    int n = arr.size();
    for (int i = 0; i < n - 1; i++) {
        bool swap
12.	Explain how bubble sort works. Write the pseudocode/algorithm for bubble sort.
12
BubbleSort(arr, n):
1. Repeat (n-1) times:
   a. Set swapped = false
   b. For i from 0 to n-2:
      i. If arr[i] > arr[i+1], then:
         - Swap arr[i] and arr[i+1]
         - Set swapped = true
   c. If swapped is false, break the loop


#include <iostream>
#include <vector>
using namespace std;

void bubbleSort(vector<int> &arr) {
    int n = arr.size();
    bool swapped;
    for (int i = 0; i < n - 1; i++) {
        swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j + 1]);
                swapped = true;
            }
        }
        if (!swapped) break;
    }
}

void printArray(const vector<int> &arr) {
    for (int num : arr)
        cout << num << " ";
    cout << endl;
}

int main() {
    vector<int> arr = {64, 34, 25, 12, 22, 11, 90};
    cout << "Original Array: ";
    printArray(arr);
    bubbleSort(arr);
    cout << "Sorted Array: ";
    printArray(arr);
    return 0;
}
13.	Explain how merge sort works. Write the pseudocode/algorithm for merge sort.
13
MergeSort(arr, left, right):
1. If left >= right, return
2. Find middle index: mid = left + (right - left) / 2
3. Recursively call MergeSort(arr, left, mid)
4. Recursively call MergeSort(arr, mid+1, right)
5. Merge(arr, left, mid, right)

Merge(arr, left, mid, right):
1. Create two temporary arrays: leftArr and rightArr
2. Copy elements from arr into leftArr and rightArr
3. Merge leftArr and rightArr back into arr in sorted order


#include <iostream>
#include <vector>
using namespace std;

void merge(vector<int> &arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    vector<int> leftArr(n1), rightArr(n2);

    for (int i = 0; i < n1; i++) leftArr[i] = arr[left + i];
    for (int j = 0; j < n2; j++) rightArr[j] = arr[mid + 1 + j];

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (leftArr[i] <= rightArr[j]) arr[k++] = leftArr[i++];
        else arr[k++] = rightArr[j++];
    }

    while (i < n1) arr[k++] = leftArr[i++];
    while (j < n2) arr[k++] = rightArr[j++];
}

void mergeSort(vector<int> &arr, int left, int right) {
    if (left >= right) return;
    int mid = left + (right - left) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

void printArray(const vector<int> &arr) {
    for (int num : arr) cout << num << " ";
    cout << endl;
}

int main() {
    vector<int> arr = {38, 27, 43, 3, 9, 82, 10};
    cout << "Original Array: ";
    printArray(arr);
    mergeSort(arr, 0, arr.size() - 1);
    cout << "Sorted Array: ";
    printArray(arr);
    return 0;
}
14.	What is a Direct Access Table? Explain with the help of an example.
14
#include <iostream>
using namespace std;

#define SIZE 101

class DirectAccessTable {
    bool table[SIZE];

public:
    DirectAccessTable() {
        for (int i = 0; i < SIZE; i++) table[i] = false;
    }

    void insert(int key) {
        if (key >= 0 && key < SIZE) table[key] = true;
    }

    void remove(int key) {
        if (key >= 0 && key < SIZE) table[key] = false;
    }

    bool search(int key) {
        if (key >= 0 && key < SIZE) return table[key];
        return false;
    }
};

int main() {
    DirectAccessTable dat;
    dat.insert(10);
    dat.insert(50);
    
    cout << "Search 10: " << (dat.search(10) ? "Found" : "Not Found") << endl;
    cout << "Search 30: " << (dat.search(30) ? "Found" : "Not Found") << endl;

    dat.remove(10);
    cout << "Search 10 after removal: " << (dat.search(10) ? "Found" : "Not Found") << endl;

    return 0;
}
15.	What do you mean by a hash function?
15
#include <iostream>
using namespace std;

#define SIZE 101

class DirectAccessTable {
    bool table[SIZE];

public:
    DirectAccessTable() {
        for (int i = 0; i < SIZE; i++) table[i] = false;
    }

    void insert(int key) {
        if (key >= 0 && key < SIZE) table[key] = true;
    }

    void remove(int key) {
        if (key >= 0 && key < SIZE) table[key] = false;
    }

    bool search(int key) {
        if (key >= 0 && key < SIZE) return table[key];
        return false;
    }
};

int main() {
    DirectAccessTable dat;
    dat.insert(10);
    dat.insert(50);
    
    cout << "Search 10: " << (dat.search(10) ? "Found" : "Not Found") << endl;
    cout << "Search 30: " << (dat.search(30) ? "Found" : "Not Found") << endl;

    dat.remove(10);
    cout << "Search 10 after removal: " << (dat.search(10) ? "Found" : "Not Found") << endl;

    return 0;
}
16.	What is a collision in hashing?
16
#include <iostream>
#include <vector>
using namespace std;

class HashTable {
    static const int SIZE = 10;
    vector<int> table[SIZE];

    int hashFunction(int key) {
        return key % SIZE;
    }

public:
    void insert(int key) {
        int index = hashFunction(key);
        table[index].push_back(key);
    }

    bool search(int key) {
        int index = hashFunction(key);
        for (int num : table[index]) {
            if (num == key) return true;
        }
        return false;
    }

    void remove(int key) {
        int index = hashFunction(key);
        for (auto it = table[index].begin(); it != table[index].end(); it++) {
            if (*it == key) {
                table[index].erase(it);
                return;
            }
        }
    }
};

int main() {
    HashTable ht;
    ht.insert(15);
    ht.insert(25);
    ht.insert(35);
    ht.insert(45);

    cout << "Search 25: " << (ht.search(25) ? "Found" : "Not Found") << endl;
    cout << "Search 50: " << (ht.search(50) ? "Found" : "Not Found") << endl;

    ht.remove(25);
    cout << "Search 25 after removal: " << (ht.search(25) ? "Found" : "Not Found") << endl;

    return 0;
}
17.	What is hashing? Name at least two collision resolution types for open addressing.
17
#include <iostream>
using namespace std;

class HashTable {
    static const int SIZE = 10;
    int table[SIZE];

public:
    HashTable() {
        for (int i = 0; i < SIZE; i++) table[i] = -1;
    }

    int hashFunction(int key) {
        return key % SIZE;
    }

    void insert(int key) {
        int index = hashFunction(key);
        while (table[index] != -1) {
            index = (index + 1) % SIZE;
        }
        table[index] = key;
    }

    bool search(int key) {
        int index = hashFunction(key);
        int start = index;
        while (table[index] != -1) {
            if (table[index] == key) return true;
            index = (index + 1) % SIZE;
            if (index == start) return false;
        }
        return false;
    }

    void remove(int key) {
        int index = hashFunction(key);
        int start = index;
        while (table[index] != -1) {
            if (table[index] == key) {
                table[index] = -1;
                return;
            }
            index = (index + 1) % SIZE;
            if (index == start) return;
        }
    }
};

int main() {
    HashTable ht;
    ht.insert(15);
    ht.insert(25);
    ht.insert(35);

    cout << "Search 25: " << (ht.search(25) ? "Found" : "Not Found") << endl;
    cout << "Search 50: " << (ht.search(50) ? "Found" : "Not Found") << endl;

    ht.remove(25);
    cout << "Search 25 after removal: " << (ht.search(25) ? "Found" : "Not Found") << endl;

    return 0;
}
18.	What is a Direct Access Table? Explain with the help of an example.
18
#include <iostream>
using namespace std;

#define SIZE 101

class DirectAccessTable {
    bool table[SIZE];

public:
    DirectAccessTable() {
        for (int i = 0; i < SIZE; i++) table[i] = false;
    }

    void insert(int key) {
        if (key >= 0 && key < SIZE) table[key] = true;
    }

    void remove(int key) {
        if (key >= 0 && key < SIZE) table[key] = false;
    }

    bool search(int key) {
        if (key >= 0 && key < SIZE) return table[key];
        return false;
    }
};

int main() {
    DirectAccessTable dat;
    dat.insert(10);
    dat.insert(50);

    cout << "Search 10: " << (dat.search(10) ? "Found" : "Not Found") << endl;
    cout << "Search 30: " << (dat.search(30) ? "Found" : "Not Found") << endl;

    dat.remove(10);
    cout << "Search 10 after removal: " << (dat.search(10) ? "Found" : "Not Found") << endl;

    return 0;
}
















